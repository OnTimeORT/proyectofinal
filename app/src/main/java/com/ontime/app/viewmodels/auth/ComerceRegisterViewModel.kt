package com.ontime.app.viewmodels.auth

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.models.AuthRepository


class ComerceRegisterViewModel(application: Application) : AndroidViewModel(application) {

    var authRepository: AuthRepository = AuthRepository(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = authRepository.userMutableLiveData

    fun updateProfileCommerce(userId: String, name: String, phone: String, cuit: String){
        return authRepository.updateProfileCommerce(userId, name,phone,cuit)
    }
}