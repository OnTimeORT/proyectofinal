package com.ontime.app.features.auth.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.features.auth.RpAuth

class VmRegister(application: Application) : AndroidViewModel(application) {

    var rpAuth: RpAuth = RpAuth(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = rpAuth.userMutableLiveData

    fun register(email: String, password: String){
       return rpAuth.register(email, password)
    }

    fun loginWithFacebook(token: AccessToken) {
        rpAuth.firebaseAuthWithFacebook(token)
    }

    fun loginWithGoogle(token: String) {
        rpAuth.firebaseAuthWithGoogle(token)
    }
}