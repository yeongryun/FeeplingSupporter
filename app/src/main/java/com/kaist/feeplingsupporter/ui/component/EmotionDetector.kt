package com.kaist.feeplingsupporter.ui.component

import android.graphics.Bitmap
import com.kaist.feeplingsupporter.ui.data.EmotionWord

typealias EmotionDegree = Double // -1.0 ~ 1.0

/*
This class consists of methods for analyzing sentiment.
 */
class EmotionDetector {
    suspend fun detectWithSelfieImage(bitmap: Bitmap): EmotionDegree = TODO()

    suspend fun detectWithWords(words: List<EmotionWord>): EmotionDegree = TODO()

    suspend fun detectWithAdjustedHrv(hrv: Double, age: Int, gender: Gender): EmotionDegree = TODO()
}


enum class Gender {
    MALE, FEMALE
}


