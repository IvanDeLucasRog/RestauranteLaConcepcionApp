package com.platzi.conf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.model.Menu

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance() // conexion directa con la base de datos
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() // para tener los datos de manera offline

    init {
        firebaseFirestore.firestoreSettings = settings // asignamos los datos ofline a la instancia de la base de datos al llamar a la clase
    }

    /*fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME) //llamamos a la colección de conferencias con variables constantes. Valdría con poner "conferences"
            .orderBy("category") // ordenar los datos en funcion de la categoría
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java) //recibir todos los speakers
                    callback.onSuccess(list)
                    break
                }
            }
    }*/

    fun getSchedule(callback: Callback<List<Menu>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Menu::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}