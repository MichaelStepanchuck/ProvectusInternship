package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "login", strict = true)
class Login : Serializable {

    @field:Element(name = "uuid")
    var uuid: String? = null
    @field:Element(name = "username")
    var username: String? = null
    @field:Element(name = "password")
    var password: String? = null
    @field:Element(name = "salt")
    var salt: String? = null
    @field:Element(name = "md5")
    var md5: String? = null
    @field:Element(name = "sha1")
    var sha1: String? = null
    @field:Element(name = "sha256")
    var sha256: String? = null

}