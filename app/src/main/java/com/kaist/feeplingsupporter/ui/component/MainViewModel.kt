package com.kaist.feeplingsupporter.ui.component

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.kaist.feeplingsupporter.ui.data.EmotionWords
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

private const val alpah = 0.25
private const val beta = 0.25
private const val gamma = 0.5

class MainViewModel: ViewModel() {
    val emotionDetector = EmotionDetector()
    val wordsList = EmotionWords.entries

    private val executor = Executors.newSingleThreadExecutor()
    private val dispatcher = executor.asCoroutineDispatcher()

    private val handler = CoroutineExceptionHandler { _, throwable -> handleError(throwable) }
    private val scope = CoroutineScope(dispatcher + handler)

    var job = scope.coroutineContext[Job]!!

    private var detectedSelfieEmotion: EmotionDegree = 0.0
    private var detectedWordsEmotion: EmotionDegree = 0.0
    private var detectedHrvEmotion: EmotionDegree = 0.0

    val sumDetectedEmotion: EmotionDegree
        get() = alpah * detectedSelfieEmotion + beta * detectedWordsEmotion + gamma * detectedHrvEmotion

    // selfie Image
    fun getSelfieImage(): Bitmap = TODO()

    // Hrv Data
    fun getHrvData(): Double = TODO()

    suspend fun detectSelfieEmotion(): EmotionDegree = withContext(scope.coroutineContext + job) {
        val emotionDegree = emotionDetector.detectWithSelfieImage(getSelfieImage())
        detectedSelfieEmotion = emotionDegree
        emotionDegree
    }

    suspend fun detectWithWords(words : List<EmotionWords>) = withContext(scope.coroutineContext + job) {
        val emotionDegree = emotionDetector.detectWithWords(words)
        detectedWordsEmotion = emotionDegree
        emotionDegree
    }

    suspend fun detectWithAdjustedHrv(hrv: Double, age: Int, gender: Gender) = withContext(scope.coroutineContext + job) {
        val emotionDegree = emotionDetector.detectWithAdjustedHrv(hrv, age, gender)
        detectedHrvEmotion = emotionDegree
        emotionDegree
    }

    suspend fun reset() {
        job.cancelAndJoin()
        job = scope.coroutineContext[Job]!!
        detectedSelfieEmotion = 0.0
        detectedWordsEmotion = 0.0
        detectedHrvEmotion = 0.0
    }

    private fun handleError(throwable: Throwable): Unit = TODO()

    override fun onCleared() {
        super.onCleared()
    }
}