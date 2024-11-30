package com.kaist.feeplingsupporter.ui.screen

import android.os.Environment
import android.util.Log
import android.view.SurfaceView
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.kaist.feeplingsupporter.ui.component.CameraHelper
import com.kaist.feeplingsupporter.ui.component.FaceEmotion
import com.kaist.feeplingsupporter.ui.component.MainViewModel
import com.kaist.feeplingsupporter.ui.component.SelfieEmotionAnalyzer.analyzeEmotion
import com.kaist.feeplingsupporter.ui.data.EmotionWord
import java.io.File

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    var selfieAnalysisResult: List<FaceEmotion> by remember { mutableStateOf(mutableListOf()) }
    var userSelectedWords: List<EmotionWord> by remember { mutableStateOf(mutableListOf()) }

    when {
        selfieAnalysisResult.isEmpty() -> CaptureScreen {
            selfieAnalysisResult = it
        }

        userSelectedWords.isEmpty() -> WordsSelectionScreen(mainViewModel) {
            userSelectedWords = it
        }

        else -> SolutionScreen()
    }
}

@Composable
fun CaptureScreen(analysisResult: (faceEmotions: List<FaceEmotion>) -> Unit) {
    val context = LocalContext.current
    var cameraHelper: CameraHelper? by remember { mutableStateOf(null) }
    var selfieImage: ImageCapture.OutputFileResults? by remember { mutableStateOf(null) }

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
                if (selfieImage != null) return@Button

                cameraHelper?.let { helper ->
                    val photoFile = File(
                        context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                        "selfie_${System.currentTimeMillis()}.jpg"
                    )
                    helper.takePhoto(photoFile) { photo ->
                        selfieImage = photo

                        if (photo == null) {
                            return@takePhoto
                        }

                        analyzeEmotion(uri = selfieImage!!.savedUri!!, onResult = { result ->
                            Log.d("MainScreen", "selfie analysis success result :$result")
                            if (result.isNotEmpty()) {
                                helper.stopCamera()
                                analysisResult.invoke(result)
                            } else {
                                Toast.makeText(context, "Face is not detected please try again", Toast.LENGTH_SHORT).show()
                                selfieImage = null
                            }
                        }, onError = { error ->
                            Log.d("MainScreen", "selfie analysis fail")
                            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            selfieImage = null
                        })

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
fun WordsSelectionScreen(mainViewModel: MainViewModel, selected: (List<EmotionWord>) -> Unit) {
    val words = mainViewModel.showRandomWords()
    val selectedWords = remember { mutableStateListOf<EmotionWord>() }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Box( modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp)) {
            Text(
                text = "Select Words ",
                modifier = Modifier
                    .align(Alignment.CenterStart) // Box의 왼쪽 끝에 위치
                    .padding(start = 8.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
            )

            Button(
                onClick = {
                    if (selectedWords.isEmpty()) {
                        Toast.makeText(context, "Select words at least one", Toast.LENGTH_SHORT).show()
                    } else {
                        selected.invoke(selectedWords)
                    }
                }, modifier = Modifier.align(Alignment.CenterEnd) // Box의 오른쪽 끝에 위치
            ) {
                Text(text = "Next > ")
            }
        }

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Pick all the words that most closely match how you are feeling. ",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            fontSize = 10.sp,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodySmall,
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(words) { word ->
                val backgroundColor = mainViewModel.getWordsColorBySubTitle(word)
                val contentColor = if (isColorDark(backgroundColor)) Color.White else Color.Black

                val isSelected = word in selectedWords

                WordItem(
                    word = word,
                    backgroundColor = if (isSelected) backgroundColor.copy(alpha = 0.7f) else backgroundColor,
                    contentColor = contentColor,
                    isSelected = isSelected,
                    onWordClick = {
                        if (isSelected) {
                            selectedWords.remove(word)
                        } else {
                            selectedWords.add(word)
                        }
                    }
                )
            }
        }
    }
}
inline fun <T> LazyListScope.items(
    items: List<T>,
    noinline key: ((item: T) -> Any)? = null,
    noinline contentType: (item: T) -> Any? = { null },
    crossinline itemContent: @Composable LazyItemScope.(item: T) -> Unit
) = items(
    count = items.size,
    key = if (key != null) { index: Int -> key(items[index]) } else null,
    contentType = { index: Int -> contentType(items[index]) }
) {
    itemContent(items[it])
}

/**
 * Adds a list of items.
 *
 * @param items the data list
 * @param key a factory of stable and unique keys representing the item. Using the same key
 * for multiple items in the grid is not allowed. Type of the key should be saveable
 * via Bundle on Android. If null is passed the position in the grid will represent the key.
 * When you specify the key the scroll position will be maintained based on the key, which
 * means if you add/remove items before the current visible item the item with the given key
 * will be kept as the first visible one.
 * @param span define custom spans for the items. Default is 1x1. It is good practice to
 * leave it `null` when this matches the intended behavior, as providing a custom implementation
 * impacts performance
 * @param contentType a factory of the content types for the item. The item compositions of
 * the same type could be reused more efficiently. Note that null is a valid type and items of such
 * type will be considered compatible.
 * @param itemContent the content displayed by a single item
 */
inline fun <T> LazyGridScope.items(
    items: List<T>,
    noinline key: ((item: T) -> Any)? = null,
    noinline span: (LazyGridItemSpanScope.(item: T) -> GridItemSpan)? = null,
    noinline contentType: (item: T) -> Any? = { null },
    crossinline itemContent: @Composable LazyGridItemScope.(item: T) -> Unit
) = items(
    count = items.size,
    key = if (key != null) { index: Int -> key(items[index]) } else null,
    span = if (span != null) { { span(items[it]) } } else null,
    contentType = { index: Int -> contentType(items[index]) }
) {
    itemContent(items[it])
}

@Composable
fun WordItem(
    word: EmotionWord,
    backgroundColor: Color,
    contentColor: Color,
    isSelected: Boolean,
    onWordClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable { onWordClick() }
            .padding(8.dp)
    ) {
        Text(
            text = word.name,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = contentColor,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Center)
        )
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Selected",
                tint = contentColor,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            )
        }
    }
}

fun isColorDark(color: Color): Boolean = color.luminance() < 0.5

@Composable
fun SolutionScreen() {

}