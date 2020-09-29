package com.ontime.app.features.scheduleRow

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrScheduleRow : Fragment() {

    companion object {
        fun newInstance() = FrScheduleRow()
    }

    private lateinit var viewModel: VmScheduleRow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_schedule_row, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmScheduleRow::class.java)
        // TODO: Use the ViewModel
    }

}