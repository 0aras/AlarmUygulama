package com.eymen.alarmuygulama

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationsChannels()
        RemindersManager.startReminder(this)
    }

    private fun createNotificationsChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                getString(R.string.reminders_notification_channel_id),
                getString(R.string.reminders_notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            )
            ContextCompat.getSystemService(this, NotificationManager::class.java)
                ?.createNotificationChannel(channel)
        }
    }
}
