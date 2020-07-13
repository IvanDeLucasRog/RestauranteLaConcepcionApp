package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Menu
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService
import java.lang.Exception

class MenuViewModel: ViewModel() { // comunica toda la información
    val firestoreService = FirestoreService() // instancia de la clase Firestore Service
    var listMenu: MutableLiveData<List<Menu>> = MutableLiveData() //añadir el LiveData
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getMenuFromFirebase()
    }

    fun getMenuFromFirebase() {
        firestoreService.getMenu(object: Callback<List<Menu>> {
            override fun onSuccess(result: List<Menu>?) {
                listMenu.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}