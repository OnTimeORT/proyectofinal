package com.ontime.app.features.auth.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.models.AuthRepository

class VmRegister(application: Application) : AndroidViewModel(application) {

    var authRepository: AuthRepository = AuthRepository(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = authRepository.userMutableLiveData

    fun register(email: String, password: String){
       return authRepository.register(email, password)
    }

    fun loginWithFacebook(token: AccessToken) {
        authRepository.firebaseAuthWithFacebook(token)
    }

    fun loginWithGoogle(token: String) {
        authRepository.firebaseAuthWithGoogle(token)
    }
}