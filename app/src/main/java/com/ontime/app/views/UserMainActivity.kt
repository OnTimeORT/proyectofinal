package com.ontime.app.views

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.ontime.app.MainActivity
import com.ontime.app.R


class UserMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // El toggle del menú hamburguesa necesita estas opciones para el menú de no videntes
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        // Inicialización del toggle
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        // Obtengo el navigation view
        val navigationView =
            findViewById<View>(R.id.nav_view) as NavigationView

        // Agrego un listener para el navigation view, esto detectará los clicks sobre los ítems
        // del menú
        navigationView.setNavigationItemSelectedListener(this)

        // Con esto seleccciono un fragment inicial y marco un ítem del menú como activo
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                userHomeCategoriesFragment()
            ).commit()
            navigationView.setCheckedItem(R.id.nav_categories)
        }
    }

    // Con esto evitas que al presionar la tecla atras vuelva al fragment anterior, en su
    // lugar cierra el menú
    override fun onBackPressed() {
        val drawer =
            findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // Modificar este if por un when

        val id = item.itemId
        var fragment: Fragment? = null
        val fragmentManager = supportFragmentManager
        if (id == R.id.nav_account_details) {
            fragment = userAccountDetailsFragment()
        } else if (id == R.id.nav_configuration) {
            fragment = userEditAccountFragment()
        } else if (id == R.id.nav_categories) {
            fragment = userHomeCategoriesFragment()
        } else if (id == R.id.nav_bookings) {
            fragment = userBookingsFragment()
        } else if (id == R.id.nav_favorites) {
            fragment = userFavoritesFragment()
        } else if (id == R.id.nav_scan_qr) {
            fragment = userScanQRFragment()
        } else if (id == R.id.nav_logout) {
            // No hago nada, deja el fragment en null así vuelve
            // al main activity
        }

        if ( fragment == null) {
            // Desloguear y volver al login
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, MainActivity::class.java))

        } else {
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment!!).commit()
        }
        val drawer =
            findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true

        // Aca un ejemplo de como hacerlo con when
        /*
        when (item.itemId) {
            R.id.nav_message -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                userAccountDetailsFragment()
            ).commit()
            R.id.nav_chat -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                userEditAccountFragment()
            ).commit()
            R.id.nav_profile -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                userBookingsFragment()
            ).commit()
            R.id.nav_share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
            R.id.nav_send -> Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show()
        }
        val drawer =
            findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
        */

        // Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()

    }
}