package com.ontime.app.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class userScanQRFragment : Fragment() {

    companion object {
        fun newInstance() = userScanQRFragment()
    }

    private lateinit var viewModel: userScanQRViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_scan_q_r_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(userScanQRViewModel::class.java)
        // TODO: Use the ViewModel
    }

}