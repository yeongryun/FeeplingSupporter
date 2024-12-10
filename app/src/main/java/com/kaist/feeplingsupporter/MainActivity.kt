package com.kaist.feeplingsupporter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kaist.feeplingsupporter.ui.alarm.HeartRateMonitorService
import com.kaist.feeplingsupporter.ui.component.HrvAnalyzer
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.screen.MainScreen
import com.kaist.feeplingsupporter.ui.theme.FeeplingSupporterTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private var isStartedService: Boolean = false
    private lateinit var serviceIntent:  Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        serviceIntent = Intent(this, HeartRateMonitorService::class.java)

        val isAlarmTriggered: Boolean = intent.getBooleanExtra("alarm", false) ?: false
        var cachedHeartRate: HrvAnalyzer.SimpleBpm? = null

        if (isAlarmTriggered) {
            val avgBpm = intent.getDoubleExtra("avgBpm", 0.0)!!
            val maxBpm = intent.getLongExtra("maxBpm", 0)!!
            val minBpm = intent.getLongExtra("minBpm", 0)!!
            cachedHeartRate = HrvAnalyzer.SimpleBpm(maxBpm, minBpm, avgBpm)
        }

        setContent {
            FeeplingSupporterTheme {
                MainScreen(mainViewModel, isAlarmTriggered, cachedHeartRate)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (isStartedService) {
            stopHeartRateMonitorService(this, serviceIntent)
            isStartedService = false
        }
    }

    override fun onStop() {
        super.onStop()
        if (!isStartedService) {
            startHeartRateMonitorService(this, serviceIntent)
            isStartedService = true
        }
    }


    private fun startHeartRateMonitorService(context: Context, intent: Intent) {
        context.startForegroundService(intent) // Foreground Service 시작
    }

    private fun stopHeartRateMonitorService(context: Context, intent: Intent) {
        context.stopService(intent) // Foreground Service 시작
    }

}
