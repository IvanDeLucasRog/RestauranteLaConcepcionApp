package com.platzi.conf.network

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.R
import com.platzi.conf.model.Menu
import com.platzi.conf.model.Plates
import com.platzi.conf.view.ui.fragments.MenuFragment
import com.platzi.conf.viewmodel.MenuViewModel

const val MENU_COLLECTION_NAME = "menu"
const val PLATES_SUBCOLLECTION_NAME = "platos"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance() // conexion directa con la base de datos
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() // para tener los datos de manera offline
    val menu = Menu()

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
    fun getPlate(callback: Callback<List<Plates>>) {
        firebaseFirestore.collectionGroup(PLATES_SUBCOLLECTION_NAME).whereEqualTo("id", "Sopas Frías")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Plates::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
            .addOnFailureListener {
                Log.e("DATABASE", "Error while conecting to the server")
            }
    }
}