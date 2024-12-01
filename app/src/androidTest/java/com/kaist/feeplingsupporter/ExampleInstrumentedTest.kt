package com.kaist.feeplingsupporter

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaist.feeplingsupporter.ui.data.Gender
import com.kaist.feeplingsupporter.ui.data.Personality
import com.kaist.feeplingsupporter.ui.screen.UserData
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kaist.feeplingsupporter", appContext.packageName)
    }

    @Test
    fun serializationTest() {
        val userData = UserData("name", 10, Gender.MALE, Personality.INTROVERT)

        val serializedData = Json.encodeToString(userData)
        val deserializedData = Json.decodeFromString<UserData>(serializedData)

        assertEquals(userData, deserializedData)
    }
}