package com.ontime.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ontime.app.MainActivity
import com.ontime.app.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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

        btnGoToRegister.setOnClickListener {
            (activity as MainActivity).goToRegister()
        }
    }

}