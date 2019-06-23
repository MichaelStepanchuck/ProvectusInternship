package com.example.provectusinternship.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "timezone", strict = true)
class Timezone: Serializable {

    @field:Element(name = "offset")
    var offset: String? = null
    @field:Element(name = "description")
    var description: String? = null

}