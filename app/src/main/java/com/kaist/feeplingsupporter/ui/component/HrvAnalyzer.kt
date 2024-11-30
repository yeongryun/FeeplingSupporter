package com.kaist.feeplingsupporter.ui.component

import android.content.Context
import android.util.Log
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.request.AggregateGroupByDurationRequest
import androidx.health.connect.client.time.TimeRangeFilter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.FitnessOptions
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.Field
import com.google.android.gms.fitness.request.DataReadRequest
import com.google.android.gms.fitness.result.DataReadResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit


class HrvAnalyzer(context: Context) {
    private val TAG = "HrvAnalyst"
    private val healthConnectClient = HealthConnectClient.getOrCreate(context)

    suspend fun aggregateStepsIntoMinutes(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): List<Bpm> {
        val result = withContext(Dispatchers.IO) {
            runCatching {
                val response =
                    healthConnectClient.aggregateGroupByDuration(
                        AggregateGroupByDurationRequest(
                            metrics = setOf(HeartRateRecord.BPM_AVG, HeartRateRecord.BPM_MAX, HeartRateRecord.BPM_MIN, HeartRateRecord.MEASUREMENTS_COUNT),
                            timeRangeFilter = TimeRangeFilter.between(startTime, endTime),
                            timeRangeSlicer = Duration.ofMinutes(1L)
                        )
                    )

                response.filter {
                    it.result[HeartRateRecord.BPM_AVG] != null
                            && it.result[HeartRateRecord.BPM_MAX] != null
                            && it.result[HeartRateRecord.BPM_MIN] != null
                }.map {
                    Bpm(
                        it.startTime,
                        it.endTime,
                        it.result[HeartRateRecord.BPM_AVG]!!,
                        it.result[HeartRateRecord.BPM_MAX]!!,
                        it.result[HeartRateRecord.BPM_MIN]!!,
                        it.result[HeartRateRecord.MEASUREMENTS_COUNT]
                    )
                }
            }.onFailure {
                Log.e(TAG, "Error reading heart rate data: ${it.message}")
            }
        }

        return result.getOrNull() ?: emptyList()
    }

    data class Bpm(
        val startTime: Instant,
        val endTime: Instant,
        val avgBpm: Long,
        val maxBpm: Long,
        val minBpm: Long,
        val count: Long?
    )

    data class OneMinuteBpm(
        val maxBpm: Long, val minBpm: Long, val avgBpm: Double
    )

    private fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}