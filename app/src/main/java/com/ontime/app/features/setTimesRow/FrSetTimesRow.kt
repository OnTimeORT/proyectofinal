package com.ontime.app.features.setTimesRow

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrSetTimesRow : Fragment() {

    companion object {
        fun newInstance() = FrSetTimesRow()
    }

    private lateinit var viewModel: VmSetTimesRow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_set_times_row, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmSetTimesRow::class.java)
        // TODO: Use the ViewModel
    }

}