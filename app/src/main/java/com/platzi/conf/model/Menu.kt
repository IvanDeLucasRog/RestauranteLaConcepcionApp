package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Menu :Serializable { // para que el objeto pueda pasar entre activities
    lateinit var title: String
    lateinit var description: String
    lateinit var tag: String
    lateinit var datetime: Date
    lateinit var speaker: String
}