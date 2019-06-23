package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "picture", strict = true)
class Picture : Serializable {

    @field:Element(name = "large")
    var large: String? = null
    @field:Element(name = "medium")
    var medium: String? = null
    @field:Element(name = "thumbnail")
    var thumbnail: String? = null

}