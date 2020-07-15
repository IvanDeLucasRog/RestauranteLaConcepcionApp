package com.platzi.conf.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Plates
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService
import java.lang.Exception

class PlateViewModel : ViewModel() {
    val firestoreService = FirestoreService ()
    var listPlates: MutableLiveData<List<Plates>> = MutableLiveData() //añadir el LiveData

    fun refresh() {
        getPlatesFromFirebase()
    }

    fun getPlatesFromFirebase() {
        firestoreService.getPlate(object: Callback<List<Plates>> {

            override fun onFailed(exception: Exception) {
                Log.e("DATABASE", "error en ViewModel")
            }

            override fun onSuccess(result: List<Plates>?) {
                listPlates.postValue(result)
            }
        })
    }

}