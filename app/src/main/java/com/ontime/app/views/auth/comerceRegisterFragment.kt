package com.ontime.app.views.auth

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R
import com.ontime.app.viewmodels.auth.ComerceRegisterViewModel
import kotlinx.android.synthetic.main.comerce_register_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*

class comerceRegisterFragment : Fragment() {

    companion object {
        fun newInstance() = comerceRegisterFragment()
    }

    private lateinit var comerceRegisterViewModel: ComerceRegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        comerceRegisterViewModel = ViewModelProviders.of(this).get(ComerceRegisterViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comerce_register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email_text.text = comerceRegisterViewModel.getEmail()
        name_text.text = comerceRegisterViewModel.getName()
    }

}