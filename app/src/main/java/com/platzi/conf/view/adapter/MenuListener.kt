package com.platzi.conf.view.adapter

import com.platzi.conf.model.Menu

interface MenuListener {
    fun onMenuClicked(menu: Menu, position: Int)
    // capturar el evento del click
}