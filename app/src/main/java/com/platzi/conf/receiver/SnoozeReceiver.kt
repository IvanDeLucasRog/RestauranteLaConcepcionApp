package com.platzi.conf.receiver

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.text.format.DateUtils
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat
import com.platzi.conf.R
import com.platzi.conf.utils.sendNotification

class SnoozeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {

        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        /*val nextNotificationTime = 20 * 1000
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + nextNotificationTime, snoozePendingIntent)*/

        notificationManager.sendNotification(context.getString(R.string.snooze_notification), context)
    }
}
