package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "registered", strict = true)
class Registered: Serializable {

    @field:Element(name = "date")
    var date: String? = null
    @field:Element(name = "age")
    var age: String? = null

}