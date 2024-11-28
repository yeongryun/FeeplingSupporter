package com.kaist.feeplingsupporter.ui.component

import android.net.Uri
import androidx.core.net.toFile
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import java.io.IOException
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlin.math.absoluteValue

object SelfieEmotionAnalyzer  {
    /**
     * 셀피 이미지의 URI를 분석하여 감정 데이터를 반환
     */
    fun analyzeEmotion(
        uri: Uri,
        onResult: (List<FaceEmotion>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val imageFile = uri.toFile()

            val bitmap = BitmapUtils.decodeSampledBitmapFromFile(imageFile.path, 360, 640)


            val image = InputImage.fromBitmap(bitmap, 0)

            // ML Kit 얼굴 탐지 옵션
            val options = FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                .build()

            val detector = FaceDetection.getClient(options)

            detector.process(image)
                .addOnSuccessListener { faces ->
                    val emotions = analyzeFaces(faces)
                    onResult(emotions)
                }
                .addOnFailureListener { exception ->
                    onError("감정 분석 실패: ${exception.message}")
                }
        } catch (e: IOException) {
            Log.d("SelfieEmotion", "load faile : $e")
            onError("이미지 로드 실패: ${e.message}")
        }
    }

    private fun analyzeFaces(faces: List<Face>): List<FaceEmotion> {
        val results = mutableListOf<FaceEmotion>()

        for ((index, face) in faces.withIndex()) {
            val smilingProbability = face.smilingProbability ?: 0f
            val leftEyeOpenProbability = face.leftEyeOpenProbability ?: 0f
            val rightEyeOpenProbability = face.rightEyeOpenProbability ?: 0f
            val headPitch = face.headEulerAngleX
            val headYaw = face.headEulerAngleY

            // 긍정/부정 점수 계산
            val positivityScore = calculateEmotionScore(
                smilingProbability,
                leftEyeOpenProbability,
                rightEyeOpenProbability,
                headPitch,
                headYaw
            )

            Log.d("SelfieEmotion", "score : $positivityScore")

            results.add(
                FaceEmotion(
                    id = index + 1,
                    positivityScore = positivityScore,
                    smilingProbability = getProbabilityLabel(smilingProbability),
                    leftEyeOpenProbability = getProbabilityLabel(leftEyeOpenProbability),
                    rightEyeOpenProbability = getProbabilityLabel(rightEyeOpenProbability),
                    headPitch = headPitch,
                    headYaw = headYaw
                )
            )
        }

        return results
    }

    /**
     * 긍정/부정 점수 계산
     * @return -1 ~ +1 범위의 감정 점수
     */
    private fun calculateEmotionScore(
        smilingProbability: Float,
        leftEyeOpenProbability: Float,
        rightEyeOpenProbability: Float,
        headPitch: Float,
        headYaw: Float
    ): Float {
        // 각 요소에 가중치 부여
        val smileWeight = 0.6f
        val eyeOpenWeight = 0.3f
        val headPoseWeight = 0.1f

        // 웃는 정도 점수
        val smileScore = smilingProbability * 2 - 1 // 0~1을 -1~+1로 변환

        // 두 눈 뜬 확률 평균
        val eyeOpenScore = ((leftEyeOpenProbability + rightEyeOpenProbability) / 2) * 2 - 1

        // 얼굴 기울기: 정면에 가까울수록 긍정적
        val headPoseScore = if (headPitch.absoluteValue < 15 && headYaw.absoluteValue < 15) 1f else -1f

        // 종합 점수 계산 (가중치 적용)
        val totalScore = (smileScore * smileWeight) +
                (eyeOpenScore * eyeOpenWeight) +
                (headPoseScore * headPoseWeight)

        // 결과를 -1 ~ +1로 정규화
        return totalScore.coerceIn(-1f, 1f)
    }

    /**
     * 확률 값을 레이블로 변환
     */
    private fun getProbabilityLabel(probability: Float): Probability {
        return when {
            probability < 0 -> Probability.UNKNOWN
            probability > 0.7 -> Probability.HIGH
            probability > 0.4 -> Probability.MID
            else -> Probability.LOW
        }
    }
}

object BitmapUtils {

    fun decodeSampledBitmapFromFile(filePath: String, reqWidth: Int, reqHeight: Int): Bitmap {
        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeFile(filePath, options)

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
        options.inJustDecodeBounds = false

        return BitmapFactory.decodeFile(filePath, options)
    }

    private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }
}

data class FaceEmotion(
    val id: Int,
    val positivityScore: Float,
    val smilingProbability: Probability,
    val leftEyeOpenProbability: Probability,
    val rightEyeOpenProbability: Probability,
    val headPitch: Float,
    val headYaw: Float
)

enum class Probability {
    HIGH, MID, LOW, UNKNOWN
}