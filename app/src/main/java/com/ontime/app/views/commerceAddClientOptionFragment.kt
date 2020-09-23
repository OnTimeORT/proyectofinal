package com.ontime.app.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class commerceAddClientOptionFragment : Fragment() {

    companion object {
        fun newInstance() = commerceAddClientOptionFragment()
    }

    private lateinit var viewModel: CommerceAddClientOptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.commerce_add_client_option_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommerceAddClientOptionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}