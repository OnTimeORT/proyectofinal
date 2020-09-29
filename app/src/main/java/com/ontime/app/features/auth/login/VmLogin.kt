package com.ontime.app.features.auth.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.features.auth.RpAuth

class VmLogin(application: Application) : AndroidViewModel(application) {

    var rpAuth: RpAuth = RpAuth(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = rpAuth.userMutableLiveData

    fun login(email: String, password: String) {
        rpAuth.login(email, password)
    }

    fun loginWithFacebook(token: AccessToken) {
        rpAuth.firebaseAuthWithFacebook(token)
    }

    fun loginWithGoogle(token: String) {
        rpAuth.firebaseAuthWithGoogle(token)
    }
}