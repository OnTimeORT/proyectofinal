package com.ontime.app.features.selectedStore.advancedQueue

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrSelectedStoreAdvancedQueue : Fragment() {

    companion object {
        fun newInstance() = FrSelectedStoreAdvancedQueue()
    }

    private lateinit var viewModel: VmSelectedStoreAdvancedQueue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fr_selected_store_advanced_queue,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(VmSelectedStoreAdvancedQueue::class.java)
        // TODO: Use the ViewModel
    }

}