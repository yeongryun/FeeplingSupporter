package com.kaist.feeplingsupporter.ui.screen

import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.SurfaceView
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.kaist.feeplingsupporter.ui.component.CameraHelper
import com.kaist.feeplingsupporter.ui.component.FaceEmotion
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.component.SelfieEmotionAnalyzer.analyzeEmotion
import com.kaist.feeplingsupporter.ui.data.EmotionWord
import java.io.File

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    var selfieImage: ImageCapture.OutputFileResults? by remember { mutableStateOf(null) }
    var analysisResult: List<FaceEmotion> by remember { mutableStateOf(mutableListOf()) }
    var userSelectedWords: List<EmotionWord> by remember { mutableStateOf(mutableListOf()) }

    when {
        selfieImage == null -> CaptureScreen { selfie ->
            selfieImage = selfie
        }

        selfieImage != null && analysisResult.isEmpty() -> EmotionAnalysisScreen(selfieImage!!.savedUri!!) {
            analysisResult = it
        }

        userSelectedWords.isEmpty() -> WordsSelectScreen(mainViewModel) {
            userSelectedWords = it
        }

        else -> SolutionScreen()
    }
}

@Composable
fun CaptureScreen(onPhotoCaptured: (outputFileResults: ImageCapture.OutputFileResults?) -> Unit) {
    val context = LocalContext.current
    // CameraXHelper를 관리하기 위한 상태
    var cameraHelper: CameraHelper? by remember { mutableStateOf(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        // SurfaceView를 AndroidView로 생성
        AndroidView(
            factory = { ctx ->
                val surfaceView = SurfaceView(ctx)
                cameraHelper = CameraHelper(ctx, surfaceView)
                surfaceView
            }, modifier = Modifier
                .weight(1f) // 화면의 상단 부분을 차지
                .fillMaxSize()
        )

        // 캡처 버튼
        Button(
            onClick = {
                cameraHelper?.let { helper ->
                    val photoFile = File(
                        context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                        "selfie_${System.currentTimeMillis()}.jpg"
                    )
                    helper.takePhoto(photoFile) { photo ->
                        onPhotoCaptured.invoke(photo)
                        val message = if (photo != null) {
                            helper.stopCamera()
                            "사진 저장 성공!"
                        } else "사진 저장 실패!"

                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Capture")
        }
    }
}

@Composable
fun EmotionAnalysisScreen(selfieUri: Uri, analysisResult: (List<FaceEmotion>) -> Unit) {
    val context = LocalContext.current
    // 감정 분석 결과 상태
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "셀피 감정 분석", modifier = Modifier.padding(8.dp))

        Button(onClick = {
            analyzeEmotion(uri = selfieUri, onResult = { result ->
                Log.d("MainScreen", "selfie analysis success result :$result")
                analysisResult.invoke(result)
            }, onError = { error ->
                Log.d("MainScreen", "selfie analysis fail")
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            })
        }) {
            Text("셀피 분석 시작")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "분석 결과:\n$analysisResult")
    }
}

@Composable
fun WordsSelectScreen(mainViewModel: MainViewModel, results: (List<EmotionWord>) -> Unit) {

}

@Composable
fun SolutionScreen() {

}