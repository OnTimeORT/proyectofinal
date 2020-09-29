package com.ontime.app.features.addClient

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrAddClientToRow : Fragment() {

    companion object {
        fun newInstance() = FrAddClientToRow()
    }

    private lateinit var viewModel: VmAddClientToRow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_add_client_to_row, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmAddClientToRow::class.java)
        // TODO: Use the ViewModel
    }

}
