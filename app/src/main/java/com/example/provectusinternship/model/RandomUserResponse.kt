package com.example.provectusinternship.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RandomUserResponse(
    @SerializedName("results")
    @Expose
    var results: List<User>? = null) : Serializable