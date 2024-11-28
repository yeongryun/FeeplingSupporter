package com.kaist.feeplingsupporter

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.screen.MainScreen
import com.kaist.feeplingsupporter.ui.theme.FeeplingSupporterTheme


@OptIn(ExperimentalPermissionsApi::class)
class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            FeeplingSupporterTheme {
                RequestCameraAndRecordAudioPermissions(
                    areGranted = {
                        MainScreen(mainViewModel)
                    },
                    areDenied = {
                        ShowRequestPermission(it)
                    }
                )
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestCameraAndRecordAudioPermissions(
    areGranted: @Composable () -> Unit,
    areDenied: @Composable (MultiplePermissionsState) -> Unit
) {
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionState())

    if (permissionsState.allPermissionsGranted) {
        areGranted.invoke()
    } else {
        Toast.makeText(
            LocalContext.current,
            "원할한 사용을 위하여 Permission 체크를 부탁드립니다. " +
                    "버튼 클릭시 반응이 없을시, 앱 설정가서 직접 퍼미션 허용을 해주셔야 합니다.",
            Toast.LENGTH_LONG
        ).show()
        areDenied.invoke(permissionsState)
    }
}

private fun permissionState() = listOf(
    Manifest.permission.CAMERA,
)


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ShowRequestPermission(multiplePermissionsState: MultiplePermissionsState) {
    Surface(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    multiplePermissionsState.launchMultiplePermissionRequest()
                }
            ) {
                Text(
                    text = "Request permission",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
                )
            }
        }
    }
}