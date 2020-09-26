package com.ontime.app.views.auth

import RegisterViewModel
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.R
import kotlinx.android.synthetic.main.register_fragment.*
import kotlinx.android.synthetic.main.register_fragment.editEmail
import kotlinx.android.synthetic.main.register_fragment.editPassword
import kotlinx.android.synthetic.main.register_fragment.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterFragment : Fragment() {

    lateinit var registerViewModel: RegisterViewModel
    lateinit var v : View
    private val prefName = "myPreferences"
    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        registerViewModel.userMutableLiveData.observe(this,
            { firebaseUser: FirebaseUser? ->
                if (firebaseUser != null) {
                    Toast.makeText(activity, "Login successfull", Toast.LENGTH_SHORT).show()

                    firebaseUser?.let {
                        val name = firebaseUser.displayName
                        val email = firebaseUser.email
                        val uid = firebaseUser.uid
                        Log.d("Este es el user",email.toString())
                        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(prefName, Context.MODE_PRIVATE)
                        val editor = sharedPref.edit()
                        editor.putString("UID", uid)
                        editor.putString("NAME", name)
                        editor.putString("EMAIL", email)

                        editor.apply()
                    }


                    Navigation.findNavController(v)
                        .navigate(R.id.action_registerFragment_to_comerceRegisterFragment)
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = inflater.inflate(R.layout.register_fragment, container, false)
        v.btnGoToLogin.setOnClickListener {
            Navigation.findNavController(v)
                .navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegister.setOnClickListener {
            if (editEmail.text.trim().toString().isNotEmpty() || editPassword.text.trim().toString()
                    .isNotEmpty()
            ) {
                registerViewModel.register(
                    editEmail.text.trim().toString(),
                    editPassword.text.trim().toString()
                )

            } else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }
    }

}