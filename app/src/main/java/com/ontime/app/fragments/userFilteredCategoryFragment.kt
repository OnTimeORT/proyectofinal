package com.ontime.app.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class userFilteredCategoryFragment : Fragment() {

    companion object {
        fun newInstance() = userFilteredCategoryFragment()
    }

    private lateinit var viewModel: userFilteredCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_filtered_category_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(userFilteredCategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}