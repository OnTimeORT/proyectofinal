package com.ontime.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.ontime.app.MainActivity
import com.ontime.app.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {


    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.btnGoToRegister.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            if (editEmail.text?.trim().toString().isNotEmpty() || editPassword.text?.trim()
                    .toString().isNotEmpty()
            ) {
                (activity as MainActivity).login(
                    editEmail.text?.trim().toString(),
                    editPassword.text?.trim().toString()
                )
            } else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }

        btnLoginGoogle.setOnClickListener {
            (activity as MainActivity).loginGoogle()
        }

        btnLoginFacebook.setOnClickListener {
            (activity as MainActivity).loginFacebook()
        }
    }

}