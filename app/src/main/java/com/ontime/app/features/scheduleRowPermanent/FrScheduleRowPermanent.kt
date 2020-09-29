package com.ontime.app.features.scheduleRowPermanent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrScheduleRowPermanent : Fragment() {

    companion object {
        fun newInstance() = FrScheduleRowPermanent()
    }

    private lateinit var viewModel: VmScheduleRowPermanent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_schedule_row_permanent, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(VmScheduleRowPermanent::class.java)
        // TODO: Use the ViewModel
    }

}