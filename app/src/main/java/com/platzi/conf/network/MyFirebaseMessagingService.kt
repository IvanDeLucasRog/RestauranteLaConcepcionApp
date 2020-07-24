package com.platzi.conf.network

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    //Esta clase sirve para mostrar los mensajes en primer plano cuando la aplicación está abierta, ya que cloud messaging los muestra cuando
    //esta apagada

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        Looper.prepare()
        Handler().post{
            val toast = Toast.makeText(baseContext, remoteMessage.notification?.title, Toast.LENGTH_LONG)
            toast.show()
        }
        Looper.loop()
    }

}