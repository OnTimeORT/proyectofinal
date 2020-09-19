package com.ontime.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.*
import com.ontime.app.fragments.LoginFragment
import com.ontime.app.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 100) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Task message", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Task message", "Google sign in failed", e)
            }
        }

        callbackManager.onActivityResult(requestCode, resultCode, data)

    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithGoogle:success")
                    val user: FirebaseUser? = auth.currentUser
                    checkCommerce(user)
                } else {
                    Log.w("Task message", "signInWithGoogle:failure", task.exception)
                }
            }
    }

    private fun firebaseAuthWithFacebook(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithFacebook:success")
                    val user = auth.currentUser
                    checkCommerce(user)
                } else {
                    Log.w("Task message", "signInWithFacebook:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun goToRegister() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, RegisterFragment.newInstance())
            .commitNow()
    }

    fun loginGoogle() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleClient = GoogleSignIn.getClient(this, gso)
        startActivityForResult(googleClient.signInIntent, 100)

    }

    fun loginFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    result?.let {
                        val token = it.accessToken
                        firebaseAuthWithFacebook(token)
                    }
                }

                override fun onCancel() {
                    Log.w("Task message", "facebook:cancel")
                }

                override fun onError(error: FacebookException?) {
                    Log.w("Task message", "facebook:failure", error)
                }
            })
    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithEmail:success")
                    val user: FirebaseUser? = auth.currentUser
                    checkCommerce(user)
                } else {
                    Log.w("Task message", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.e("Task message", "Successful")
                } else {
                    Log.e("Task message", "Error", task.exception)
                }
            }
    }

    private fun checkCommerce(user: FirebaseUser?) {
        user?.getIdToken(false)?.addOnSuccessListener { result ->
            val isCommerce = result.claims["isCommerce"] as? Boolean
            if (isCommerce == true) {
                Toast.makeText(this, "Soy comercio!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Soy usuario!", Toast.LENGTH_LONG).show()
            }
        }
    }
}