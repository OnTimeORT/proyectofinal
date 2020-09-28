package com.ontime.app.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R
import com.ontime.app.viewmodels.userSelectedStoreAdvancedQueueViewModel

class userSelectedStoreAdvancedQueue : Fragment() {

    companion object {
        fun newInstance() = userSelectedStoreAdvancedQueue()
    }

    private lateinit var viewModel: userSelectedStoreAdvancedQueueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.user_selected_store_advanced_queue_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(userSelectedStoreAdvancedQueueViewModel::class.java)
        // TODO: Use the ViewModel
    }

}