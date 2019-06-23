package com.example.provectusinternship.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "user",strict = false)
class RandomUserResponse {
    @field:ElementList(name = "results",inline = true)
    var results: List<User>? = null

}