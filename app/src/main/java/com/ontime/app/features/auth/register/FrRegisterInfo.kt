package com.ontime.app.features.auth.register

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.ontime.app.R
import kotlinx.android.synthetic.main.fr_register_info.*

class FrRegisterInfo : Fragment(){

    /*quitar los findviewbyid*/
    /*agregar los @string en los layout */
    private lateinit var vmRegisterInfo: VmRegisterInfo
    lateinit var v : View
    lateinit var emailText : EditText
    lateinit var nameText : EditText
    lateinit var phoneText : EditText
    private val prefName = "myPreferences"

    companion object {
        fun newInstance() = FrRegisterInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vmRegisterInfo = ViewModelProviders.of(this).get(VmRegisterInfo::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fr_register_info, container, false)
        nameText = v.findViewById(R.id.nameEditText)
        emailText = v.findViewById(R.id.emailEditText)
        phoneText = v.findViewById(R.id.phoneEditText)

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

            var name = if(nameText.text.trim().toString().isNotEmpty()) nameText.text.trim().toString() else ""
            var phone = if(phoneText.text.trim().toString().isNotEmpty()) phoneText.text.trim().toString() else ""

            if (name != "" && phone != "") {
                val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)
                val uid = sharedPref.getString("UID", "").toString()

                vmRegisterInfo.updateProfileCommerce(uid,name,phone)

                Navigation.findNavController(v)
                    .navigate(R.id.action_frRegisterInfo_to_frLogin)
            }

        }
    }
}