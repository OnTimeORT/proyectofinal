package com.ontime.app.models

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.ontime.app.preferences.PreferenceProvider


class AuthRepository(var application: Application) {
    var userMutableLiveData: MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val pref: PreferenceProvider
        get() {
            TODO()
        }

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithEmail:success")
                    val user: FirebaseUser? = firebaseAuth.currentUser
                    userMutableLiveData.postValue(firebaseAuth.currentUser)

                    user?.let {
                    val name = user.displayName
                    val email = user.email
                        pref.login(name, email)
                    }


                } else {
                    Log.w("Task message", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        application.applicationContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun register(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) { task ->
                if (task.isSuccessful) {
                    userMutableLiveData.postValue(firebaseAuth.currentUser)
                    Log.e("Task message", "Successful")
                    Toast.makeText(
                        application.applicationContext, "Register successfull",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    Log.e("Task message", "Error", task.exception)
                    Toast.makeText(
                        application.applicationContext, "Register failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithGoogle:success")
                    userMutableLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Log.w("Task message", "signInWithGoogle:failure", task.exception)
                }
            }
    }

    fun firebaseAuthWithFacebook(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithFacebook:success")
                    userMutableLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Log.w("Task message", "signInWithFacebook:failure", task.exception)
                    Toast.makeText(
                        application.applicationContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun secondStepRegisterStore() {

    }
}
