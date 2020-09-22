package com.ontime.app.views.auth

import LoginViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseUser
import com.ontime.app.MainActivity
import com.ontime.app.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    lateinit var loginViewModel: LoginViewModel
    private val callbackManager = CallbackManager.Factory.create()

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.userMutableLiveData.observe(this,
            { firebaseUser: FirebaseUser? ->
                if (firebaseUser != null) {
                    Toast.makeText(activity, "User signed in", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.btnGoToRegister.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Colocar en variables email
        btnLogin.setOnClickListener {
            if (editEmail.text?.trim().toString().isNotEmpty() || editPassword.text?.trim()
                    .toString().isNotEmpty()
            ) {
                loginViewModel.login(
                    editEmail.text?.trim().toString(),
                    editPassword.text?.trim().toString()
                )
            } else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }

        btnLoginGoogle.setOnClickListener {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val googleClient = GoogleSignIn.getClient((activity as MainActivity), gso)
            startActivityForResult(googleClient.signInIntent, 100)
        }

        btnLoginFacebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                        result?.let {
                            val token = it.accessToken
                            loginViewModel.loginWithFacebook(token)
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
                loginViewModel.loginWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Task message", "Google sign in failed", e)
            }
        }

        callbackManager.onActivityResult(requestCode, resultCode, data)

    }

}