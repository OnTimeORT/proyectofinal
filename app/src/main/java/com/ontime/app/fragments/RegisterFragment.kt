package com.ontime.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ontime.app.MainActivity
import com.ontime.app.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.editEmail
import kotlinx.android.synthetic.main.fragment_register.editPassword
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
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
                (activity as MainActivity).createUser(
                    editEmail.text.trim().toString(),
                    editPassword.text.trim().toString()
                )
            } else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }
    }

}