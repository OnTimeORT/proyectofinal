package com.ontime.app.models
/*
import android.os.Parcel
import android.os.Parcelable

class Store(name: String?, email: String?, phone: String?, category: String?, imageUrl: String?) : Parcelable {


    var name: String = ""
    var email: String = ""
    var phone: String = ""
    var category: String = ""
    var imageUrl: String = ""

    constructor() : this("","","","","")

    init {
        this.name: name!!
        this.email: email!!
        this.phone: phone!!
        this.category: category!!
        this.imageUrl: imageUrl!!
    }

    constructor(source: Parcel) : this(
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
        writeString(phone)
        writeString(category)
        writeString(imageUrl)
    }

    override fun toString(): String {
        return "User(name='$name', email='$email', phone='$phone', category='$category', imageUrl=$imageUrl)"
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}*/