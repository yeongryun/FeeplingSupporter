package com.kaist.feeplingsupporter.ui.screen

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaist.feeplingsupporter.ui.data.Gender
import com.kaist.feeplingsupporter.ui.data.Interest
import com.kaist.feeplingsupporter.ui.data.Personality
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDate

@Serializable
data class UserData(
    val name: String,
    val age: Int,
    val gender: Gender,
    val personality: Personality,
    val interest: Interest
)

fun saveUserData(context: Context, userData: UserData) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // JSON으로 직렬화
    val jsonData = Json.encodeToString(userData)

    // SharedPreferences에 저장
    with(sharedPreferences.edit()) {
        putString("user_data", jsonData)
        apply()
    }
}

fun loadUserData(context: Context): UserData? {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // 저장된 JSON 문자열 불러오기
    val jsonData = sharedPreferences.getString("user_data", null)

    // JSON 문자열이 null이 아니면 역직렬화
    return if (jsonData != null) {
        Json.decodeFromString<UserData>(jsonData)
    } else {
        null // 저장된 데이터가 없을 경우 null 반환
    }
}

@Composable
fun SignupScreen(onSignup: () -> Unit) {
    val context = LocalContext.current
    var name: String by remember { mutableStateOf("user") }
    var selectedYear by remember { mutableStateOf("") }
    var calculatedAge by remember { mutableIntStateOf(0) }
    var birthMenuExpanded by remember { mutableStateOf(false) }

    var gender: Gender by remember { mutableStateOf(Gender.MALE) }
    var personality: Personality by remember { mutableStateOf(Personality.INTROVERT) }
    var interest: Interest by remember { mutableStateOf(Interest.SOCIAL) }

    val years = (1970..2020).map { it.toString() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.SpaceBetween // 위-아래 간격 분배
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "JOIN",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 20.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold
                ),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = name, onValueChange = { name = it }, label = {
                if (name.isEmpty()) {
                    Text("Select your name", color = Color.LightGray)
                } else {
                    Text("Name", color = Color.Black)
                }
            }, textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = if (name.isEmpty()) {
                    Color.LightGray
                } else {
                    Color.Black
                }
            ), modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Birth Year Dropdown
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.d("YRLEE", "box click")
                    birthMenuExpanded = true
                }) {
                OutlinedTextField(value = selectedYear, onValueChange = {}, label = {
                    Text(
                        "Birth Year", color = if (calculatedAge == 0) {
                            Color.LightGray
                        } else {
                            Color.Black
                        }
                    )
                }, modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        Log.d("YRLEE", "text click 2222")
                    }, textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = if (calculatedAge == 0) Color.LightGray else Color.Black
                ), trailingIcon = {
                    IconButton(onClick = { birthMenuExpanded = !birthMenuExpanded }) {
                        if (birthMenuExpanded) {
                            Icon(
                                imageVector = androidx.compose.material.icons.Icons.Default.KeyboardArrowUp,
                                contentDescription = "Expand Dropdown"
                            )
                        } else {
                            Icon(
                                imageVector = androidx.compose.material.icons.Icons.Default.KeyboardArrowDown,
                                contentDescription = "Expand Dropdown"
                            )
                        }
                    }
                }, readOnly = true)

                // Dropdown Menu
                DropdownMenu(expanded = birthMenuExpanded,
                    onDismissRequest = { birthMenuExpanded = false }) {
                    years.forEach { year ->
                        DropdownMenuItem(text = { Text(year) }, onClick = {
                            selectedYear = year
                            calculatedAge = getCurrentYear() - year.toInt()
                            birthMenuExpanded = false
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Gender Dropdown
            GenderDropdownMenu(selectedGender = gender, onGenderSelected = { gender = it })
            Spacer(modifier = Modifier.height(8.dp))

            PersonalitySelector(personality) {
                personality = it
            }

            Spacer(modifier = Modifier.height(8.dp))

            InterestSelector(interest) {
                interest = it
            }

            Spacer(modifier = Modifier.height(16.dp))
        }


        Button(
            onClick = {
                if (name.isNotBlank() && calculatedAge != 0) {
                    val userData = UserData(name, calculatedAge, gender, personality, interest)
                    saveUserData(context, userData)
                    onSignup()
                }
            }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}

fun getCurrentYear(): Int {
    return LocalDate.now().year
}

@Composable
fun PersonalitySelector(personality: Personality, onPersonalitySelected: (Personality) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Personality:")

        // Introvert Option
        PersonalityOption(personality = Personality.INTROVERT,
            isSelected = personality == Personality.INTROVERT,
            onSelect = { onPersonalitySelected(Personality.INTROVERT) })

        Spacer(modifier = Modifier.width(8.dp))

        // Extrovert Option
        PersonalityOption(personality = Personality.EXTROVERT,
            isSelected = personality == Personality.EXTROVERT,
            onSelect = { onPersonalitySelected(Personality.EXTROVERT) })
    }
}

@Composable
fun PersonalityOption(
    personality: Personality, isSelected: Boolean, onSelect: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = onSelect)
        Text(
            text = personality.name,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 10.sp, fontStyle = FontStyle.Italic
            ),
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp) // Padding for better spacing
        )
    }
}

@Composable
fun InterestSelector(interest: Interest, onInterestSelected: (Interest) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Interest:")

        InterestOption(interest = Interest.SOCIAL,
            isSelected = interest == Interest.SOCIAL,
            onSelect = { onInterestSelected(Interest.SOCIAL) })

        Spacer(modifier = Modifier.width(8.dp))

        InterestOption(interest = Interest.PHYSICAL,
            isSelected = interest == Interest.PHYSICAL,
            onSelect = { onInterestSelected(Interest.PHYSICAL) })
    }
}

@Composable
fun InterestOption(
    interest: Interest, isSelected: Boolean, onSelect: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = onSelect)
        Text(
            text = interest.name,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 10.sp, fontStyle = FontStyle.Italic
            ),
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp) // Padding for better spacing
        )
    }
}

@Composable
fun GenderDropdownMenu(
    selectedGender: Gender, onGenderSelected: (Gender) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(value = selectedGender.name,
            onValueChange = {},
            label = { Text("Gender", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black
            ),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    if (expanded) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.KeyboardArrowUp,
                            contentDescription = "Expand Dropdown"
                        )
                    } else {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand Dropdown"
                        )
                    }
                }
            })

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Gender.values().forEach { gender ->
                DropdownMenuItem(text = { Text(gender.name) }, onClick = {
                    onGenderSelected(gender)
                    expanded = false
                })
            }
        }
    }
}