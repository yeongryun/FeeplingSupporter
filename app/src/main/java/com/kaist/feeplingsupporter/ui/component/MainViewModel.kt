package com.kaist.feeplingsupporter.ui.component

import android.app.Application
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.core.math.MathUtils.clamp
import androidx.lifecycle.AndroidViewModel
import com.kaist.feeplingsupporter.ui.data.AgeGroup
import com.kaist.feeplingsupporter.ui.data.EmotionLevel
import com.kaist.feeplingsupporter.ui.data.EmotionWord
import com.kaist.feeplingsupporter.ui.data.Gender
import com.kaist.feeplingsupporter.ui.data.Solution
import com.kaist.feeplingsupporter.ui.screen.UserData
import com.kaist.feeplingsupporter.ui.screen.loadUserData
import java.time.Duration
import java.time.LocalDateTime

private const val alpah = 0.25
private const val beta = 0.25
private const val gamma = 0.5

typealias EmotionDegree = Double // -1.0 ~ 1.0

class MainViewModel(private val app: Application): AndroidViewModel(app) {
    private val wordsEmotionAnalyzer = WordsEmotionAnalyzer()
    private val hrvAnalyzer = HrvAnalyzer(app.baseContext)

    fun decideEmotionLevel(
        hrv: HrvAnalyzer.SimpleBpm?,
        selfieAnalysisResult: List<FaceEmotion>,
        userSelectedWords: List<EmotionWord>
    ): EmotionLevel {
        val detectedSelfieEmotion = selfieAnalysisResult.firstOrNull()?.positivityScore ?: 0f
        val detectedHrvEmotion = calculateEmotionScore(hrv?.avgBpm ?: 100.0)
        val detectedWordsEmotion = userSelectedWords.calcEmotionWordDegree()

        val userData =
            requireNotNull(loadUserData(app.baseContext)) { "userData is not initialized" }
        val ageFactor = 1 - userData.age.toDouble() / 100
        val genderFactor = when (userData.gender) {
            Gender.MALE -> 0.7
            Gender.FEMALE -> 0.9
        }

        val hrvAdjusted = detectedHrvEmotion * ageFactor * genderFactor

        val emotionDegree = clamp(
            alpah * hrvAdjusted + beta * detectedSelfieEmotion + gamma * detectedWordsEmotion,
            -1.0,
            1.0
        )


         val result =  when {
            emotionDegree > 0.7 -> EmotionLevel.POSITIVE_HIGH
            emotionDegree > 0.4 -> EmotionLevel.POSITIVE_MODERATE
            emotionDegree > 0 -> EmotionLevel.POSITIVE_LOW
            emotionDegree > -0.4 -> EmotionLevel.NEGATIVE_LOW
            emotionDegree > -0.7 -> EmotionLevel.NEGATIVE_MODERATE
            else -> EmotionLevel.NEGATIVE_HIGH
        }

        Log.d("YRLEE", "@@@@ emotion Degree : $emotionDegree result : $result")
        return result
    }

    private fun calculateEmotionScore(heartRate: Double, minHeartRate: Int = 40, maxHeartRate: Int = 200): Double {
        // 심박수가 최소값과 최대값 사이인지 확인
        if (heartRate < minHeartRate || heartRate > maxHeartRate) {
            throw IllegalArgumentException("Heart rate must be between $minHeartRate and $maxHeartRate")
        }

        // Min-Max Normalization을 통해 -1 ~ +1 범위로 변환
        val normalizedScore = (heartRate - minHeartRate) / (maxHeartRate - minHeartRate)
        val emotionScore = 2 * normalizedScore - 1

        return emotionScore
    }

    fun getSolutions(emotionLevel: EmotionLevel, solutionRefreshCount: Int): List<Solution> {
        val userData =
            requireNotNull(loadUserData(app.baseContext)) { "userData is not initialized" }

        return Solution.entries.filter { it.filteringSolutionsWithUser(userData, emotionLevel, solutionRefreshCount) }
    }

    private fun Solution.filteringSolutionsWithUser(userData: UserData, emotionLevel: EmotionLevel, solutionRefreshCount: Int): Boolean {
        val ageGroup = when (userData.age) {
            in 0..19 -> AgeGroup.TEENAGE
            in 20..29 -> AgeGroup.TWENTY
            in 30..39 -> AgeGroup.THIRTY
            in 40..49 -> AgeGroup.FOURTY
            in 50..59 -> AgeGroup.FIFTY
            else -> AgeGroup.SIXTY_ABOVE
        }

        return when (solutionRefreshCount) {
            0 -> this.ageGroup == ageGroup && this.gender == userData.gender && this.personality == userData.personality && this.interest == userData.interest && this.emotionLevel == emotionLevel
            1 -> this.gender == userData.gender && this.personality == userData.personality && this.interest == userData.interest && this.emotionLevel == emotionLevel
            2 -> this.gender == userData.gender && this.interest == userData.interest && this.emotionLevel == emotionLevel
            3 -> this.interest == userData.interest && this.emotionLevel == emotionLevel
            else -> this.emotionLevel == emotionLevel
        }
    }

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

    fun List<EmotionWord>.calcEmotionWordDegree() = wordsEmotionAnalyzer.calcDegree(this)
}