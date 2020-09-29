package com.ontime.app.features.addClient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ontime.app.R

class FrAddClientOption : Fragment() {

    companion object {
        fun newInstance() = FrAddClientOption()
    }

    private lateinit var viewModel: VmAddClientOption

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_add_client_option, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmAddClientOption::class.java)
        // TODO: Use the ViewModel
    }

}