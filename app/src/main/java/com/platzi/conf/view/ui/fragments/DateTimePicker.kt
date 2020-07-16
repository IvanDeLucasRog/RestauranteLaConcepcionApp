package com.platzi.conf.view.ui.fragments
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.platzi.conf.R
import java.util.*

class DateTimePicker : DatePickerDialog.OnDateSetListener,  TimePickerDialog.OnTimeSetListener {
    lateinit var et_reservationDate: EditText
    lateinit var et_reservationTime: EditText
    lateinit var ib_reservationDate: ImageButton
    lateinit var ib_reservationTime: ImageButton
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    fun setupDateTimePicker() {
        et_reservationDate.findViewById<EditText>(R.id.et_reservationDate)
        et_reservationTime.findViewById<EditText>(R.id.et_reservationTime)
        ib_reservationDate.findViewById<EditText>(R.id.ib_reservationDate)
        ib_reservationTime.findViewById<EditText>(R.id.ib_reservationTime)

        ib_reservationDate.setOnClickListener {

        }


    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("Not yet implemented")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        TODO("Not yet implemented")
    }

}