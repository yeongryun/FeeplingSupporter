package com.kaist.feeplingsupporter

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.records.StepsRecord
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.fitness.FitnessOptions
import com.google.android.gms.fitness.data.DataType
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.screen.MainScreen
import com.kaist.feeplingsupporter.ui.theme.FeeplingSupporterTheme


@OptIn(ExperimentalPermissionsApi::class)
class MainActivity : ComponentActivity() {
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
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestCameraAndRecordAudioPermissions(
    areGranted: @Composable () -> Unit,
    areDenied: @Composable (MultiplePermissionsState) -> Unit
) {
    val context = LocalContext.current

    var fitnessPermissionState by remember { mutableStateOf(false) }
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionState())
    val fitnessOptions = FitnessOptions.builder()
        .addDataType(DataType.TYPE_HEART_RATE_BPM, FitnessOptions.ACCESS_READ)
        .build()

    val requestPermissionActivityContract = PermissionController.createRequestPermissionResultContract()

    val requestPermissions = rememberLauncherForActivityResult(requestPermissionActivityContract) { granted ->
        fitnessPermissionState = granted.containsAll(healthPermission())
    }

    LaunchedEffect(permissionsState) {
        val healthConnectClient = HealthConnectClient.getOrCreate(context)
        val granted = healthConnectClient.permissionController.getGrantedPermissions()
        if (!granted.containsAll(healthPermission())) {
            requestPermissions.launch(healthPermission())
        } else {
            fitnessPermissionState = true
        }

        if (permissionsState.allPermissionsGranted) {
            val account = GoogleSignIn.getAccountForExtension(context, fitnessOptions)
            Log.d("YRLEE", "fitnessPermissionState : ${GoogleSignIn.hasPermissions(account, fitnessOptions)}")
        }
    }

    if (permissionsState.allPermissionsGranted && fitnessPermissionState) {
        areGranted.invoke()
    } else {
        Log.d("YRLEE", "fail fitnessPermissionState : $fitnessPermissionState")
        Toast.makeText(
            LocalContext.current,
            "원할한 사용을 위하여 Permission 체크를 부탁드립니다. " +
                    "버튼 클릭시 반응이 없을시, 앱 설정가서 직접 퍼미션 허용을 해주셔야 합니다.",
            Toast.LENGTH_LONG
        ).show()
        areDenied.invoke(permissionsState)
    }
}

private fun permissionState() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    listOf(
        Manifest.permission.CAMERA,
        Manifest.permission.BODY_SENSORS,
        Manifest.permission.ACTIVITY_RECOGNITION,
    )
} else {
    listOf(
        Manifest.permission.CAMERA,
        Manifest.permission.BODY_SENSORS
    )
}

private fun healthPermission() = setOf(
    HealthPermission.getReadPermission(HeartRateRecord::class),
    HealthPermission.getWritePermission(HeartRateRecord::class),
    HealthPermission.getReadPermission(StepsRecord::class),
    HealthPermission.getWritePermission(StepsRecord::class)
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