package com.ontime.app

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class commerceScheduleRowFragment : Fragment() {

    companion object {
        fun newInstance() = commerceScheduleRowFragment()
    }

    private lateinit var viewModel: CommerceScheduleRowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.commerce_schedule_row_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommerceScheduleRowViewModel::class.java)
        // TODO: Use the ViewModel
    }

}