package com.kaist.feeplingsupporter.ui.component

import android.graphics.Color
import android.util.Log
import com.kaist.feeplingsupporter.ui.data.EmotionSubTitle
import com.kaist.feeplingsupporter.ui.data.EmotionWord
import com.kaist.feeplingsupporter.ui.theme.Blue20
import com.kaist.feeplingsupporter.ui.theme.Blue40
import com.kaist.feeplingsupporter.ui.theme.Blue80
import com.kaist.feeplingsupporter.ui.theme.Green40
import com.kaist.feeplingsupporter.ui.theme.Green80
import com.kaist.feeplingsupporter.ui.theme.Green90
import com.kaist.feeplingsupporter.ui.theme.GreenGray50
import com.kaist.feeplingsupporter.ui.theme.Orange30
import com.kaist.feeplingsupporter.ui.theme.Orange40
import com.kaist.feeplingsupporter.ui.theme.Orange80
import com.kaist.feeplingsupporter.ui.theme.Pink30
import com.kaist.feeplingsupporter.ui.theme.Pink40
import com.kaist.feeplingsupporter.ui.theme.Pink80
import com.kaist.feeplingsupporter.ui.theme.Pink90
import com.kaist.feeplingsupporter.ui.theme.Purple20
import com.kaist.feeplingsupporter.ui.theme.Purple40
import com.kaist.feeplingsupporter.ui.theme.Purple90
import com.kaist.feeplingsupporter.ui.theme.Red20
import com.kaist.feeplingsupporter.ui.theme.Red30
import com.kaist.feeplingsupporter.ui.theme.Red40
import com.kaist.feeplingsupporter.ui.theme.Red80
import com.kaist.feeplingsupporter.ui.theme.Red90
import com.kaist.feeplingsupporter.ui.theme.Yellow20
import com.kaist.feeplingsupporter.ui.theme.Yellow40
import com.kaist.feeplingsupporter.ui.theme.Yellow90
import kotlin.random.Random

class WordsEmotionAnalyzer {
    private val sufferingWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Suffering }
    private val tormentWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Torment }
    private val horrorWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Horror }
    private val rageWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Rage }
    private val shameWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Shame }
    private val disgustWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Disgust }
    private val neglectWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Neglect }
    private val exasperationWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Exasperation }
    private val sadnessWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Sadness }
    private val disappointmentWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Disappointment }
    private val envyWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Envy }
    private val irritationWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Irritation }
    private val nervousnessWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Nervousness }
    private val sympathyWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Sympathy }
    private val surpriseWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Surprise }
    private val longingWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Longing }
    private val lustWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Lust }
    private val enthrallmentWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Enthrallment }
    private val zestWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Zest }
    private val affectionWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Affection }
    private val reliefWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Relief }
    private val prideWords = EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Pride }
    private val optimismWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Optimism }
    private val contentmentWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Contentment }
    private val cheerfulnessWords =
        EmotionWord.entries.filter { it.subtitle == EmotionSubTitle.Cheerfulness }


    fun showRandomWords(): List<EmotionWord> {
        val random = Random(3)

        return listOf(
            sufferingWords.random(random),
            tormentWords.random(random),
            horrorWords.random(random),
            rageWords.random(random),
            shameWords.random(random),
            disgustWords.random(random),
            neglectWords.random(random),
            exasperationWords.random(random),
            sadnessWords.random(random),
            disappointmentWords.random(random),
            envyWords.random(random),
            irritationWords.random(random),
            nervousnessWords.random(random),
            sympathyWords.random(random),
            surpriseWords.random(random),
            longingWords.random(random),
            lustWords.random(random),
            enthrallmentWords.random(random),
            zestWords.random(random),
            affectionWords.random(random),
            reliefWords.random(random),
            prideWords.random(random),
            optimismWords.random(random),
            contentmentWords.random(random),
            cheerfulnessWords.random(random)
        ).sorted()
    }

    fun calcDegree(emotions: List<EmotionWord>): Double {
        return emotions.map { it.subtitle.degree }.average()
    }

    fun getWordsColorBySubTitle(emotionSubTitle: EmotionSubTitle) = when (emotionSubTitle) {
        EmotionSubTitle.Suffering -> Red20
        EmotionSubTitle.Torment -> Red30
        EmotionSubTitle.Horror -> Red40
        EmotionSubTitle.Rage -> Pink30
        EmotionSubTitle.Shame -> Pink40
        EmotionSubTitle.Disgust -> Red80
        EmotionSubTitle.Neglect -> Pink80
        EmotionSubTitle.Exasperation -> Purple20
        EmotionSubTitle.Sadness -> Purple40
        EmotionSubTitle.Disappointment -> Yellow20
        EmotionSubTitle.Envy -> Yellow40
        EmotionSubTitle.Irritation -> Orange30
        EmotionSubTitle.Nervousness -> Orange40
        EmotionSubTitle.Sympathy -> GreenGray50
        EmotionSubTitle.Surprise -> Blue20
        EmotionSubTitle.Longing -> Blue40
        EmotionSubTitle.Lust -> Green40
        EmotionSubTitle.Enthrallment -> Green80
        EmotionSubTitle.Zest -> Blue80
        EmotionSubTitle.Affection -> Purple90
        EmotionSubTitle.Relief -> Pink90
        EmotionSubTitle.Pride -> Yellow90
        EmotionSubTitle.Optimism -> Orange80
        EmotionSubTitle.Contentment -> Green90
        EmotionSubTitle.Cheerfulness -> Red90
    }
}