package com.example.provectusinternship.model

import android.annotation.SuppressLint
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "name", strict = true)
class Name : Serializable {

    @field:Element(name = "title")
    var title: String? = null
    @field:Element(name = "first")
    var first: String? = null
    @field:Element(name = "last")
    var last: String? = null


    @SuppressLint("DefaultLocale")
    override fun toString(): String {
        return "${title!!.capitalize()} ${first!!.capitalize()} ${last!!.capitalize()}"
    }

}