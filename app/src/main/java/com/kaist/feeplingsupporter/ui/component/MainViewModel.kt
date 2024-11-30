package com.kaist.feeplingsupporter.ui.component

import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.AndroidViewModel
import com.kaist.feeplingsupporter.ui.data.EmotionWord
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.withContext
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.Executors

private const val alpah = 0.25
private const val beta = 0.25
private const val gamma = 0.5

typealias EmotionDegree = Double // -1.0 ~ 1.0

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val wordsEmotionAnalyzer = WordsEmotionAnalyzer()
    private val hrvAnalyzer = HrvAnalyzer(app.baseContext)

    private val executor = Executors.newSingleThreadExecutor()
    private val dispatcher = executor.asCoroutineDispatcher()

    private val handler = CoroutineExceptionHandler { _, throwable -> handleError(throwable) }
    private val scope = CoroutineScope(dispatcher + handler)

    var job = scope.coroutineContext[Job]!!

    private var detectedSelfieEmotion: EmotionDegree = 0.0
    private var detectedWordsEmotion: EmotionDegree = 0.0
    private var detectedHrvEmotion: EmotionDegree = 0.0

    val sumDetectedEmotion: EmotionDegree
        get() = alpah * detectedSelfieEmotion + beta * detectedHrvEmotion + gamma * detectedWordsEmotion * 100


    // Hrv Data
    suspend fun getHrvData(): HrvAnalyzer.SimpleBpm {
        val now = LocalDateTime.now()
        val oneMinuteAgo = now.minusMinutes(1)

        val hrv = hrvAnalyzer.aggregateHeartRateData(oneMinuteAgo, now, Duration.ofMinutes(1L))

        val max = hrv.maxBy { bpm -> bpm.maxBpm }.maxBpm
        val min = hrv.minBy { bpm -> bpm.minBpm }.minBpm
        val avg = hrv.map { bpm -> bpm.avgBpm }.average()

        return HrvAnalyzer.SimpleBpm(max, min, avg)
    }

    @VisibleForTesting
    suspend fun getTestHrvData(): HrvAnalyzer.SimpleBpm = hrvAnalyzer.getTestHrvData()

    fun showRandomWords() = wordsEmotionAnalyzer.showRandomWords()

    fun getWordsColorBySubTitle(emotionWord: EmotionWord) =
        wordsEmotionAnalyzer.getWordsColorBySubTitle(emotionWord.subtitle)

    fun List<EmotionWord>.calcDegree() = wordsEmotionAnalyzer.calcDegree(this)

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