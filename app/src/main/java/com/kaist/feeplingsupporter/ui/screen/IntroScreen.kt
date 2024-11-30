package com.kaist.feeplingsupporter.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaist.feeplingsupporter.R
import com.kaist.feeplingsupporter.ui.theme.Blue80
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(onTimeout: () -> Unit) {
    // Animation for the text opacity
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    // Timer to switch to the next screen
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        onTimeout() // Call the function to move to the next screen
    }

    // UI
    Box(
        modifier = Modifier
            .fillMaxSize().background(Blue80),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icon
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your icon
                contentDescription = "App Icon",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Animated Text
            Text(
                text = "Feeling Supporter",
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(alpha) // Apply the animated opacity
            )
        }
    }
}