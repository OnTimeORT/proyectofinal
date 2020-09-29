package com.ontime.app.models

import android.os.Parcel
import android.os.Parcelable

data class User(
    val name: String? = null,
    val phone: String? = null,
    val imageUrl: String? = null
)

    /* Para hacerlo parcelable
    constructor() : this("","","","","","")

    init {
        this.name: name!!
        this.email: email!!
        this.phone: phone!!
        this.category: category!!
        this.cuit: cuit!!
        this.imageUrl: imageUrl!!
    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(email)
        writeString(category)
        writeString(phone)
        writeString(cuit)
        writeString(imageUrl)
    }

    override fun toString(): String {
        return "User(name='$name', email='$email',category='$category', phone='$phone', cuit='$cuit', imageUrl=$imageUrl)"
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }

     */
