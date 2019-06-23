package com.example.provectusinternship.model

import android.annotation.SuppressLint
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "results")
class User : Serializable {

    @field:Element(name = "gender")
     var gender: String? = null

    @field:Element(name = "name")
     var name: Name? = null

    @field:Element(name = "location")
     var location: Location? = null

    @field:Element(name = "email")
     var email: String? = null

    @field:Element(name = "login")
    var login: Login? = null

    @field:Element(name = "dob")
    var dob: DoB? = null

    @field:Element(name = "registered")
    var registered: Registered? = null

    @field:Element(name = "phone")
    var phone: String? = null

    @field:Element(name = "cell")
    var cell: String? = null

    @field:Element(name = "id")
    var id: ID? = null

    @field:Element(name = "picture")
    var picture: Picture? = null

    @field:Element(name = "nat")
    var nat: String? = null


    @SuppressLint("DefaultLocale")
    fun toArray() : Array<String?>{
        return arrayOf(gender!!.capitalize(),phone, login!!.username, login!!.password,location!!.city!!.capitalize(),location!!.street,location!!.postcode)
    }

}