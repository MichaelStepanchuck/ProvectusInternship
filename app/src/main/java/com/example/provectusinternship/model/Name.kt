package com.example.provectusinternship.model

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Name(
    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("first")
    @Expose
    var first: String? = null,

    @SerializedName("last")
    @Expose
    var last: String? = null) : Serializable {


    @SuppressLint("DefaultLocale")
    override fun toString(): String {
        return "${title!!.capitalize()} ${first!!.capitalize()} ${last!!.capitalize()}"
    }

}