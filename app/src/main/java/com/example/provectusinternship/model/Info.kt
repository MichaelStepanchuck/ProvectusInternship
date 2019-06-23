package com.example.provectusinternship.model

import org.simpleframework.xml.Element


class Info {
    @field:Element(name = "seed")
    var seed: String? = null
    @field:Element(name = "results")
    var results: Int? = null
    @field:Element(name = "page")
    var page: Int? = null
    @field:Element(name = "version")
    var version: String? = null

}