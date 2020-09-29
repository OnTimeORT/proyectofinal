package com.ontime.app.features.nearestStoresList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrNearestStoresList : Fragment() {

    companion object {
        fun newInstance() = FrNearestStoresList()
    }

    private lateinit var viewModel: VmNearestStoresList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_nearest_stores_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmNearestStoresList::class.java)
        // TODO: Use the ViewModel
    }

}