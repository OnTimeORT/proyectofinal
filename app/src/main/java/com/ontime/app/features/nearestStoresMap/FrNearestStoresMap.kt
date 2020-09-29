package com.ontime.app.features.nearestStoresMap

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrNearestStoresMap : Fragment() {

    companion object {
        fun newInstance() = FrNearestStoresMap()
    }

    private lateinit var viewModel: VmNearestStoresMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_nearest_stores_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmNearestStoresMap::class.java)
        // TODO: Use the ViewModel
    }

}