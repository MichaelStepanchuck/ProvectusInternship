package com.example.provectusinternship.model

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("gender")
    @Expose
    var gender: String? = null,

    @SerializedName("name")
    @Expose
    var name: Name? = null,

    @SerializedName("location")
    @Expose
    var location: Location? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("login")
    @Expose
    var login: Login? = null,

    @SerializedName("dob")
    @Expose
    var dob: DoB? = null,

    @SerializedName("registered")
    @Expose
    var registered: Registered? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("cell")
    @Expose
    var cell: String? = null,

    @SerializedName("id")
    @Expose
    var id: ID? = null,

    @SerializedName("picture")
    @Expose
    var picture: Picture? = null,

    @SerializedName("nat")
    @Expose
    var nat: String? = null) : Serializable {

    @SuppressLint("DefaultLocale")
    fun toArray() : Array<String?>{
        return arrayOf(gender!!.capitalize(),phone, login!!.username, login!!.password,location!!.city!!.capitalize(),location!!.street,location!!.postcode)
    }

}