package com.platzi.conf.view.ui.fragments


import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.snackbar.Snackbar


import com.platzi.conf.R
import com.platzi.conf.receiver.SnoozeReceiver
import com.platzi.conf.utils.cancelNotifications
import com.platzi.conf.utils.sendNotification
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.fragment_reservation.*
import java.text.SimpleDateFormat
import java.util.*


class ReservationFragment : Fragment() {

    //lateinit var alarmManager: AlarmManager

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
        /*var et_reservationPeopleText = et_reservationPeople.text
        var et_reservationDateText = et_reservationDate.text
        var et_reservationTimeText = et_reservationTime.text
        var et_reservationPeticion = et_reservationPeticion.text
        var et_reservationNameText = et_reservationName.text
        var et_reservationPhoneText = et_reservationPhone.text
        var et_resrationEmailText = et_reservationEmail.text*/

        createChannel(getString(R.string.notification_channel_id), getString(R.string.notification_channel_name))
        ib_reservationTime.setOnClickListener {
            setTimePicker()
        }
        ib_reservationDate.setOnClickListener {
            setDatePicker()
        }
        btn_reservation.setOnClickListener {
            setNotifications(requireContext())
            /*if (phoneNumberOk() && emailOk(et_reservationEmail.editableText.toString()) /*&& nameOk() && dateOk() && timeOk()*/){
                Toast.makeText(view.context, "Email enviado correctamente", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(view.context, "Faltan campos", Toast.LENGTH_LONG).show()
            }*/
        }

    }

    fun setTimePicker() {
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            et_reservationTime.setText(SimpleDateFormat("HH:mm").format(cal.time))
        }
        TimePickerDialog(
            view?.context,
            timeSetListener,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true
        ).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun setDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            requireView().context,
            DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDayOfMonth ->
                if (mYear >= year && mMonth >= month && mDayOfMonth >= day) {
                    et_reservationDate.setText("$mDayOfMonth/$mMonth/$mYear")
                } else {
                    showToast("Seleccione una fecha válida")
                }
            }, year, month, day)
        datePickerDialog.show()
    }
    fun showToast(textOutput: String){
        //Custom Toast
        val inflater = layoutInflater
        var container: ViewGroup? = custom_toast_container
        val layout = inflater.inflate(R.layout.custom_toast, container) as ViewGroup
        val text: TextView = layout.findViewById(R.id.toastText)
        text.text = textOutput
        with (Toast(view?.context)) {
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
    /*fun peopleNumberOk(): Boolean {
        var correct : Boolean
        if (et_reservationPeople.toString().isEmpty()){
            correct = false
            Toast.makeText(view?.context, "Inserte el número de personas", Toast.LENGTH_LONG).show()
        }else{
            val peopleNumber = et_reservationPeople.toString().toInt()
             if (peopleNumber<20) {
                 correct = true
             } else {
                 correct = false
                 Toast.makeText(view?.context, "Para reservas de más de 20 personas contacte directamente con el restaurante", Toast.LENGTH_LONG).show()
             }
        }
        return correct
    }
    fun phoneNumberOk(): Boolean{
        var correct : Boolean
            if (et_reservationPhone.length() >=9) {
                correct = true
            } else {
                correct = false
                Toast.makeText(view?.context, "Inserte un número de teléfono válido", Toast.LENGTH_LONG).show()
            }
        return correct
    }
    fun emailOk(email: String): Boolean{
        var correct : Boolean
            if (email == android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false
        return
    }
    fun nameOk(): Boolean{
        var correct : Boolean
        if (et_reservationName.text != null) {
            correct = false
            Toast.makeText(view?.context, "Inserte nombre y apellidos para reservar", Toast.LENGTH_LONG).show()
        }else{
            correct = true
        }
        return correct
    }
    fun dateOk(): Boolean{
        var correct : Boolean
        if (et_reservationDate.toString().isEmpty()) {
            correct = false
            Toast.makeText(view?.context, "Inserte una fecha para reservar", Toast.LENGTH_LONG).show()
        }else{
            correct = true
        }
        return correct
    }
    fun timeOk(): Boolean{
        var correct : Boolean
        if (et_reservationTime.toString().isEmpty()) {
            correct = false
            Toast.makeText(view?.context, "Inserte una hora para reservar", Toast.LENGTH_LONG).show()
        }else{
            correct = true
        }
        return correct
    }*/
    fun setNotifications(context: Context){
        val notificationManager =
            ContextCompat.getSystemService(
                requireView().context,
                NotificationManager::class.java
            ) as NotificationManager
        notificationManager.sendNotification(requireContext().getString(R.string.reservation_soon), requireContext())
        //setAlarm(context)

        //notificationManager.cancelNotifications()

    }
    /*fun setAlarm (context: Context){
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val second = 20 * 1000
        val intent = Intent(context, SnoozeReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
    }*/
    private fun createChannel(channelId: String, channelName: String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = requireContext().getString(R.string.reservation_soon)

            val notificationManager = requireActivity().getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }


}


