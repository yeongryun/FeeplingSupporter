package com.kaist.feeplingsupporter.ui.alarm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.kaist.feeplingsupporter.BaseActivity
import com.kaist.feeplingsupporter.MainActivity
import com.kaist.feeplingsupporter.ui.component.HrvAnalyzer
import kotlinx.coroutines.*

class HeartRateMonitorService : Service() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    private val notificationChannelId = "heart_rate_monitor_channel"

    private lateinit var hrvAnalyzer: HrvAnalyzer

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startForeground(1, createNotification())
        hrvAnalyzer = HrvAnalyzer(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        scope.launch {
            while (true) {
                delay(10_000) // 10초 간격으로 실행
                val heartRate = hrvAnalyzer.getTestHrvData()

                if (heartRate.maxBpm > 100) {
                    sendHeartRateAlert(heartRate)
                }
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotification(): Notification {
        // 알림 클릭 시 MainActivity로 이동하는 Intent
        val intent = Intent(this, BaseActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle("Heart Rate Monitor")
            .setContentText("Monitoring your heart rate in real time.")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setOngoing(true)
            .setContentIntent(pendingIntent) // 알림 클릭 시 실행
            .build()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "heart_rate_monitor_channel",
            "Heart Rate Monitoring",
            NotificationManager.IMPORTANCE_LOW
        )
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    private fun sendHeartRateAlert(heartRate: HrvAnalyzer.SimpleBpm) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("alarm", true) // 알람 클릭 시 true 전달
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "heart_rate_monitor_channel")
            .setContentTitle("High Heart Rate Alert!")
            .setContentText("Your heart rate is ${heartRate.maxBpm} BPM.")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify((System.currentTimeMillis() % 10000).toInt(), notification)
    }
}