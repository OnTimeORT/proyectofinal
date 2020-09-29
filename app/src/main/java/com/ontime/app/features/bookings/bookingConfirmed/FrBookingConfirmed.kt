package com.ontime.app.features.bookings.bookingConfirmed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontime.app.R

class FrBookingConfirmed : Fragment() {

    companion object {
        fun newInstance() = FrBookingConfirmed()
    }

    private lateinit var viewModel: VmBookingConfirmed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_booking_confirmed, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VmBookingConfirmed::class.java)
        // TODO: Use the ViewModel
    }

}