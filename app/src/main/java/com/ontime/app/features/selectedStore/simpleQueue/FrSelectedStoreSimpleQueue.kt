package com.ontime.app.features.selectedStore.simpleQueue

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrSelectedStoreSimpleQueue : Fragment() {

    companion object {
        fun newInstance() = FrSelectedStoreSimpleQueue()
    }

    private lateinit var viewModel: VmSelectedStoreSimpleQueue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fr_selected_store_simple_queue,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(VmSelectedStoreSimpleQueue::class.java)
        // TODO: Use the ViewModel
    }

}