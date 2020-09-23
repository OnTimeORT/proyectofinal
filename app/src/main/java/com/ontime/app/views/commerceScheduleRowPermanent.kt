package com.ontime.app.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class commerceScheduleRowPermanent : Fragment() {

    companion object {
        fun newInstance() = commerceScheduleRowPermanent()
    }

    private lateinit var viewModel: CommerceScheduleRowPermanentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.commerce_schedule_row_permanent_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(CommerceScheduleRowPermanentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}