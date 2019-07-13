package com.example.provectusinternship.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ID(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("value")
    @Expose
    var value: String? = null) : Serializable