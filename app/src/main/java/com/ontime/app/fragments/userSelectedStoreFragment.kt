package com.ontime.app.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class userSelectedStoreFragment : Fragment() {

    companion object {
        fun newInstance() = userSelectedStoreFragment()
    }

    private lateinit var viewModel: userSelectedStoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_selected_store_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(userSelectedStoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}