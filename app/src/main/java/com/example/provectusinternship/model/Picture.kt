package com.example.provectusinternship.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Picture(
    @SerializedName("large")
    @Expose
    var large: String? = null,

    @SerializedName("medium")
    @Expose
    var medium: String? = null,

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null) : Serializable