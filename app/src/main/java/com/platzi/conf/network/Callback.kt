package com.platzi.conf.network

import java.lang.Exception

interface Callback<T> { // permite implementar las funciones que necesitamos cuando queremos recibir info de un servidor externo
    // T significa que pueden ser datos distintos
    fun onSuccess(result: T?) // resultado exitoso al conectarse a firebase

    fun onFailed(exception: Exception)
}