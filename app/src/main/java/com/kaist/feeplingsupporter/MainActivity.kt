package com.kaist.feeplingsupporter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.screen.MainScreen
import com.kaist.feeplingsupporter.ui.theme.FeeplingSupporterTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isAlarmTriggered: Boolean = intent?.getBooleanExtra("alarm", false) ?: false

        setContent {
            FeeplingSupporterTheme {
                MainScreen(mainViewModel, isAlarmTriggered)
            }
        }
    }
}
