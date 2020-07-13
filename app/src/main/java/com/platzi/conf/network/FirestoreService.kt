package com.platzi.conf.network

import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.model.Menu

const val MENU_COLLECTION_NAME = "menu"
const val PLATES_SUBCOLLECTION_NAME = "platos"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance() // conexion directa con la base de datos
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() // para tener los datos de manera offline

    init {
        firebaseFirestore.firestoreSettings = settings // asignamos los datos ofline a la instancia de la base de datos al llamar a la clase
    }


    fun getMenu(callback: Callback<List<Menu>>) {
        firebaseFirestore.collection(MENU_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Menu::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
            .addOnFailureListener {
                Log.e("DATABASE", "Error while conecting to the server")
            }
    }
    fun getPlate(callback: Callback<List<Menu>>) {
        firebaseFirestore.collection(PLATES_SUBCOLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Menu::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
            .addOnFailureListener {
                Log.e("DATABASE", "Error while conecting to the server")
            }
    }
}