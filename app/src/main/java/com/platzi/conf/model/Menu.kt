package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Menu :Serializable { // para que el objeto pueda pasar entre activities
    var title: String = ""
    var tag: String = ""
    lateinit var imageUrl: String
    lateinit var imageDetail: String
}