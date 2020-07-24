package com.platzi.conf.utils

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.platzi.conf.R
import com.platzi.conf.receiver.SnoozeReceiver
import com.platzi.conf.view.ui.activities.MainActivity

const val NOTIFICATION_ID =
    12345 //si queremos mostrar más notificaciones deberíamos crear nuevos o random ID
private val REQUEST_CODE = 0
private val FLAGS = 0

fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    val contentIntent = Intent(applicationContext, MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(applicationContext, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    val snoozeIntent = Intent(applicationContext, SnoozeReceiver::class.java)
    val snoozePendingIntent: PendingIntent = PendingIntent.getBroadcast(
        applicationContext,
        REQUEST_CODE,
        snoozeIntent,
        PendingIntent.FLAG_ONE_SHOT
    )

    val notificationImage = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.nuestra_terraza)
    val bigPicStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(notificationImage)
        .bigLargeIcon(null)

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.notification_channel_id)
    )
        .setSmallIcon(R.drawable.logo_suelto)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent) //Intent al main Activity
        .setAutoCancel(true) //para que cuando cliquemos desaparezca la notificación
        .setStyle(bigPicStyle)
        .setLargeIcon(notificationImage)
        .addAction(R.drawable.logo_suelto, applicationContext.getString(R.string.snooze),snoozePendingIntent)
        .setPriority(NotificationCompat.PRIORITY_LOW)


    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications(){
    cancelAll()

}
