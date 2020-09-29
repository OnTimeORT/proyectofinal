package com.ontime.app.features.auth.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.features.auth.RpAuth


class VmRegisterInfo(application: Application) : AndroidViewModel(application) {

    var rpAuth: RpAuth = RpAuth(application)
    var userMutableLiveData: MutableLiveData<FirebaseUser> = rpAuth.userMutableLiveData

    fun updateProfileCommerce(userId: String, name: String, category: String, phone: String, cuit: String){
        return rpAuth.updateProfileCommerce(userId, name,category,phone,cuit)
    }

    fun getCategories() : ArrayList<String>{
        return rpAuth.getCategories()
    }
}