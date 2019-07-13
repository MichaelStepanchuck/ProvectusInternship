package com.example.provectusinternship.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Registered(
    @SerializedName("date")
    @Expose
    var date: String? = null,

    @SerializedName("age")
    @Expose
    var age: String? = null) : Serializable