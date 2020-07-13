package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Menu :Serializable { // para que el objeto pueda pasar entre activities
    lateinit var title: String
    var price: Double = 0.0
    lateinit var tag: String
    lateinit var plate: String
    lateinit var imageUrl: String
    lateinit var imageDetail: String
}