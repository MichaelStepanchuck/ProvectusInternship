package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "coordinates", strict = true)
class Coordinates: Serializable {

    @field:Element(name = "latitude")
    var latitude: String? = null
    @field:Element(name = "longitude")
    var longitude: String? = null

}