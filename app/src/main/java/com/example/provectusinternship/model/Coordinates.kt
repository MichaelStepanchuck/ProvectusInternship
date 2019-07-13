package com.example.provectusinternship.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coordinates(
    @SerializedName("date")
    @Expose
    var latitude: String? = null,

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null):Serializable



