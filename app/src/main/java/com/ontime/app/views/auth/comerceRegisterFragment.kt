package com.ontime.app.views.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.R
import com.ontime.app.viewmodels.auth.ComerceRegisterViewModel
import kotlinx.android.synthetic.main.comerce_register_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*

class comerceRegisterFragment : Fragment() {

    /*quitar los findviewbyid*/
    /*agregar los @string en los layout */
    private lateinit var comerceRegisterViewModel: ComerceRegisterViewModel
    lateinit var v : View
    lateinit var emailText : EditText
    lateinit var nameText : EditText
    lateinit var phoneText : EditText
    lateinit var cuitText : EditText
    private val prefName = "myPreferences"

    companion object {
        fun newInstance() = comerceRegisterFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        comerceRegisterViewModel = ViewModelProviders.of(this).get(ComerceRegisterViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.comerce_register_fragment, container, false)
        nameText = v.findViewById(R.id.nameEditText)
        emailText = v.findViewById(R.id.emailEditText)
        phoneText = v.findViewById(R.id.phoneEditText)
        cuitText = v.findViewById(R.id.cuitEditText)

        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)

        val nameSharedPref = sharedPref.getString("NAME", "").toString()
        val emailSharedPref = sharedPref.getString("EMAIL", "").toString()

        Log.d("Este es el mail", emailSharedPref)
        Toast.makeText(activity, nameSharedPref, Toast.LENGTH_LONG).show()

        if(nameSharedPref!="") {
            nameText.setText(nameSharedPref)
        }
        if(emailSharedPref!="") {
            emailText.setText(emailSharedPref)
        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCompleteRegister.setOnClickListener {
            /*agregar categoria*/

            var name = if(nameText.text.trim().toString().isNotEmpty()) nameText.text.trim().toString() else ""
            var phone = if(phoneText.text.trim().toString().isNotEmpty()) phoneText.text.trim().toString() else ""
            var cuit= if(cuitText.text.trim().toString().isNotEmpty()) cuitText.text.trim().toString() else ""

            if (name != "" && phone != "" && cuit != "") {
                val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)
                val uid = sharedPref.getString("UID", "").toString()
                comerceRegisterViewModel.updateProfileCommerce(uid,name,phone,cuit)
            }

        }
    }


}