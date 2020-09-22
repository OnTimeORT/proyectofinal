package com.ontime.app.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class userNearestStoresListFragment : Fragment() {

    companion object {
        fun newInstance() = userNearestStoresListFragment()
    }

    private lateinit var viewModel: userNearestStoresListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_nearest_stores_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(userNearestStoresListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}