package com.ontime.app.views.auth

import RegisterViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.R
import kotlinx.android.synthetic.main.register_fragment.*
import kotlinx.android.synthetic.main.register_fragment.editEmail
import kotlinx.android.synthetic.main.register_fragment.editPassword
import kotlinx.android.synthetic.main.register_fragment.view.*

class RegisterFragment : Fragment() {

    lateinit var registerViewModel: RegisterViewModel

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        registerViewModel.userMutableLiveData.observe(this,
            { firebaseUser: FirebaseUser? ->
                if (firebaseUser != null) {
                    Toast.makeText(activity, "User signed in", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.register_fragment, container, false)
        view.btnGoToLogin.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return view
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
                Navigation.findNavController(view)
                    .navigate(R.id.action_registerFragment_to_comerceRegisterFragment)

            } else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }
    }

}