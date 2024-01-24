package com.everestnav.foregroundservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService : Service() {

    //receives an intent - to create bound service
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    //commands that you want the service to run
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.START.toString() -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run is active")
            .setContentText("Elapsed time : 00:50")
            .build()


        startForeground(1, notification)
    }

    enum class Actions{
        START,
        STOP
    }
}