package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "location", strict = true)
class Location : Serializable {

    @field:Element(name = "street")
    var street: String? = null
    @field:Element(name = "city")
    var city: String? = null
    @field:Element(name = "state")
    var state: String? = null
    @field:Element(name = "postcode")
    var postcode: String? = null
    @field:Element(name = "coordinates")
    var coordinates: Coordinates? = null
    @field:Element(name = "timezone")
    var timezone: Timezone? = null


}