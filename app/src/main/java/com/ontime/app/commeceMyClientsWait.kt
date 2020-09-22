package com.ontime.app

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class commeceMyClientsWait : Fragment() {

    companion object {
        fun newInstance() = commeceMyClientsWait()
    }

    private lateinit var viewModel: CommeceMyClientsWaitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.commece_my_clients_wait_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommeceMyClientsWaitViewModel::class.java)
        // TODO: Use the ViewModel
    }

}