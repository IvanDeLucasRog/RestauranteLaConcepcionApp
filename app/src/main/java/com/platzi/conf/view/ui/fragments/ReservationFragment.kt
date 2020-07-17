package com.platzi.conf.view.ui.fragments


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.annotation.RequiresApi


import com.platzi.conf.R
import kotlinx.android.synthetic.main.fragment_reservation.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class ReservationFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //peopleNumberSpinnerAdapter.setUpSpinner(view.context) Instancia para poder llamar al spinner si lo implementamos algún día
        var et_reservationPeopleText = et_reservationPeople.text
        var et_reservationDateText = et_reservationDate.text
        var et_reservationTimeText = et_reservationTime.text
        var et_reservationPeticion = et_reservationPeticion.text
        var et_reservationNameText = et_reservationName.text
        var et_reservationPhoneText = et_reservationPhone.text
        var et_resrationEmailText = et_reservationEmail.text

        ib_reservationTime.setOnClickListener {
            setTimePicker()
        }
        ib_reservationDate.setOnClickListener {
            setDatePicker()
        }


    }
    fun setTimePicker(){
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            et_reservationTime.setText(SimpleDateFormat("HH:mm").format(cal.time))
        }
        TimePickerDialog(view?.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun setDatePicker(){
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(requireView().context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDayOfMonth ->
            et_reservationDate.setText("$mDayOfMonth/$mMonth/$mYear")
        }, year, month, day)
        datePickerDialog.show()
    }



}


