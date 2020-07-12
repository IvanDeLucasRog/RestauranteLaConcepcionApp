package com.platzi.conf.view.adapter

import com.platzi.conf.model.Menu

interface ScheduleListener {
    fun onConferenceClicked(menu: Menu, position: Int)
    // capturar el evento del click
}