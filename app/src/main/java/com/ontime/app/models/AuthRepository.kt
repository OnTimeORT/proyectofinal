package com.ontime.app.models

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore


class AuthRepository(var application: Application) {

    /*agregar atributos privados*/
    /*agregar las explicaciones a cada funcion*/

    var userMutableLiveData: MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    fun login(email: String, password: String) : FirebaseUser? {
        var user : FirebaseUser? = null

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) { task ->
                if (task.isSuccessful) {
                    Log.d("Task message", "signInWithEmail:success")
                    user = firebaseAuth.currentUser
                    userMutableLiveData.postValue(firebaseAuth.currentUser)

                } else {
                    Log.w("Task message", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        application.applicationContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        return user
    }

    fun register(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) { task ->
                if (task.isSuccessful) {
                    userMutableLiveData.postValue(firebaseAuth.currentUser)
                    Log.e("Task message", "Successful" + firebaseAuth.currentUser)
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

    fun updateProfileCommerce(userId: String, name: String, category: String, phone: String, cuit: String){

        val storeData = Commerce(name,category,phone, cuit, null)

        db.collection("stores").document(userId)
            .set(storeData)
            .addOnSuccessListener {
                Log.d("El comercio fue almacenado en la bd", "DocumentSnapshot successfully written!")
                Toast.makeText(
                    application.applicationContext, "El comercio se registro con éxito",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener {
                    e -> Log.w("El comercio no se pudo registrar", "Error writing document", e)
                Toast.makeText(
                    application.applicationContext, "El comercio no se pudo registrar",
                    Toast.LENGTH_SHORT
                ).show()}
    }

    fun getCategories() : ArrayList<String> {

        var categories : ArrayList<String> = arrayListOf()
        categories.add("Seleccionar categoría")

        db.collection("categories").get()
            .addOnSuccessListener { result ->

                for(category in result){
                    category.getString("name")?.let { categories.add(it) }
                  }
                }
            .addOnFailureListener {
                    e -> Log.w("No se pudo acceder a las categorias", "Error getting document", e)
                }
        return categories
    }

}
