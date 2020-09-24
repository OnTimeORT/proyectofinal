package com.ontime.app.viewmodels.auth

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.models.AuthRepository
import com.ontime.app.preferences.PreferenceProvider


class ComerceRegisterViewModel(application: Application) : AndroidViewModel(application) {

    var authRepository: AuthRepository = AuthRepository(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = authRepository.userMutableLiveData
    lateinit var pref : PreferenceProvider

    fun getEmail() : String? {
        val isSigned = pref.isSigned()
        var email : String? = ""

        if (isSigned) {
            email = pref.getEmail()
        }
        return email
    }

    fun getName() : String? {
        val isSigned = pref.isSigned()
        var name : String? = ""

        if (isSigned) {
            name = pref.getName()
        }
        return name
    }
}