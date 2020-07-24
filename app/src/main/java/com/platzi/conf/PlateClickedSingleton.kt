package com.platzi.conf

class PlateClickedSingleton {
    var clicked = ""
    companion object{
        private var instance : PlateClickedSingleton? = null
        fun getInstance() : PlateClickedSingleton {
            if (instance == null) instance = PlateClickedSingleton()
            return instance as PlateClickedSingleton
        }

    }
}
