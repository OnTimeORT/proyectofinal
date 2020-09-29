package com.ontime.app.features.rowsActive

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrRowsActive : Fragment() {

    companion object {
        fun newInstance() = FrRowsActive()
    }

    private lateinit var viewModel: VmRowsActive

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_rows_active, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmRowsActive::class.java)
        // TODO: Use the ViewModel
    }

}