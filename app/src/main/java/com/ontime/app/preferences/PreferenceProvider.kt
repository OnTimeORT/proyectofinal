package com.ontime.app.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

const val KEY_SIGNED = "key_signed"
const val KEY_NAME = "key_name"
const val KEY_EMAIL = "key_email"

class PreferenceProvider(context: Context) {

    private val appContext = context.applicationContext
    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun login(name: String?, email: String?){
        val editor = preference.edit()
        editor.putBoolean(KEY_SIGNED, true)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_NAME, name)
        editor.apply()
    }

    fun register(name: String?, email: String?){
        val editor = preference.edit()
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_NAME, name)
        editor.apply()
    }

    fun logout(){
        preference.edit().putBoolean(KEY_SIGNED, false).apply()
    }

    fun isSigned(): Boolean {
        return preference.getBoolean(KEY_SIGNED,false)
    }

    fun getEmail(): String? {
        return preference.getString(KEY_EMAIL,null)
    }

    fun getName(): String? {
        return preference.getString(KEY_NAME,null)
    }
}