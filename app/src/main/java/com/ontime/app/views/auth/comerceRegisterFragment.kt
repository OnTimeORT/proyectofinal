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
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.R
import com.ontime.app.viewmodels.auth.ComerceRegisterViewModel
import kotlinx.android.synthetic.main.comerce_register_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*

class comerceRegisterFragment : Fragment() {

    private lateinit var comerceRegisterViewModel: ComerceRegisterViewModel
    lateinit var v : View
    lateinit var email_text : TextView
    lateinit var name_text : TextView
    private val PREF_NAME = "myPreferences"
    var user : FirebaseUser? = null

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
        name_text = v.findViewById(R.id.name_text)
        email_text = v.findViewById(R.id.email_text)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        Log.d("Este es el mail", sharedPref.getString("EMAIL","nada").toString())
        Toast.makeText(activity, sharedPref.getString("NAME","nada").toString(), Toast.LENGTH_LONG).show()
        email_text.text = sharedPref.getString("NAME","nada")
        name_text.text = sharedPref.getString("EMAIL","nada")
    }


}