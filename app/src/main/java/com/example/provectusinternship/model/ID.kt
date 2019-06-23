package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "id", strict = true)
class ID : Serializable {

    @field:Element(name = "name", required = false)
    var name: String? = null
    @field:Element(name = "value" , required = false)
    var value: String? = null
}