package com.kaist.feeplingsupporter.ui.component

import android.content.Context
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraHelper(
    private val context: Context,
    surfaceView: SurfaceView
) {
    private lateinit var cameraProvider: ProcessCameraProvider
    private var cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    private var imageCapture: ImageCapture? = null
    private var camera: Camera? = null

    init {
        // SurfaceView의 Holder 콜백 설정
        surfaceView.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                // Surface가 생성되었을 때 카메라를 시작
                startCamera(holder.surface)
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) = Unit

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                // Surface가 파괴되었을 때 카메라 자원 해제
                stopCamera()
            }
        })
    }

    /**
     * 카메라 초기화 및 Preview 설정
     */
    private fun startCamera(surface: Surface) {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
                cameraProviderFuture.addListener({
                    cameraProvider = cameraProviderFuture.get()

                    // Preview UseCase 설정
                    val preview = Preview.Builder()
                        .setTargetResolution(Size(720, 1280)) // 원하는 해상도 설정
                        .build()

                    // Surface를 Preview에 연결
                    preview.setSurfaceProvider { request ->
                        request.provideSurface(surface, cameraExecutor) {
                            // Surface 해제 시 처리

                        }
                    }
                    // ImageCapture UseCase 설정
                    imageCapture = ImageCapture.Builder()
                        .setTargetResolution(Size(360, 640))
                        .build()

                    // 카메라 셀렉터 (전면 카메라 선택)
                    val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA

                    // UseCase를 CameraProvider에 바인딩
                    cameraProvider.unbindAll()
                    camera = cameraProvider.bindToLifecycle(
                        context as androidx.lifecycle.LifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                    )
                }, ContextCompat.getMainExecutor(context))
            }.onFailure {
                Log.d("TAG", "camera open fail : $it")
            }
        }
    }

    /**
     * 사진 캡처
     */
    fun takePhoto(outputFile: File, onPhotoCaptured: (outputFileResults: ImageCapture.OutputFileResults?) -> Unit) {
        val imageCapture = imageCapture ?: return

        val outputOptions = ImageCapture.OutputFileOptions.Builder(outputFile).build()

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(context),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    onPhotoCaptured(outputFileResults) // 성공
                }

                override fun onError(exception: ImageCaptureException) {
                    onPhotoCaptured(null) // 실패
                }
            }
        )
    }

    /**
     * 카메라 자원 해제
     */
    fun stopCamera() {
        if (::cameraProvider.isInitialized) {
            cameraProvider.unbindAll()
        }
        cameraExecutor.shutdown()
    }
}