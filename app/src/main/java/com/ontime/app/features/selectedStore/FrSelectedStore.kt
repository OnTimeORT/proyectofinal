package com.ontime.app.features.selectedStore

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrSelectedStore : Fragment() {

    companion object {
        fun newInstance() = FrSelectedStore()
    }

    private lateinit var viewModel: VmSelectedStore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_selected_store, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmSelectedStore::class.java)
        // TODO: Use the ViewModel
    }

}