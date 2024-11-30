package com.kaist.feeplingsupporter.ui.component

import android.content.Context
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.request.AggregateGroupByDurationRequest
import androidx.health.connect.client.time.TimeRangeFilter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale
import kotlin.random.Random


class HrvAnalyzer(context: Context) {
    private val TAG = "HrvAnalyst"
    private val healthConnectClient = HealthConnectClient.getOrCreate(context)

    suspend fun aggregateHeartRateData(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
        timeRangeSlicer: Duration
    ): List<Bpm> {
        val result = withContext(Dispatchers.IO) {
            runCatching {
                healthConnectClient.aggregateGroupByDuration(
                    AggregateGroupByDurationRequest(
                        metrics = setOf(
                            HeartRateRecord.BPM_AVG,
                            HeartRateRecord.BPM_MAX,
                            HeartRateRecord.BPM_MIN,
                            HeartRateRecord.MEASUREMENTS_COUNT
                        ),
                        timeRangeFilter = TimeRangeFilter.between(startTime, endTime),
                        timeRangeSlicer = timeRangeSlicer
                    )
                ).convertInternalBpm()
            }.onFailure {
                Log.e(TAG, "Error reading heart rate data: ${it.message}")
            }
        }

        return result.getOrNull() ?: emptyList()
    }

    private fun List<AggregationResultGroupedByDuration>.convertInternalBpm(): List<Bpm> = filter {
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

    @VisibleForTesting
    suspend fun getTestHrvData(): SimpleBpm {
        return withContext(Dispatchers.Default) {
            val min = Random.nextInt(30, 80)
            val max = Random.nextInt(min+10, 230)
            val avg = Random.nextInt(min, max)

            SimpleBpm(max.toLong(), min.toLong(), avg.toDouble())
        }
    }


    data class Bpm(
        val startTime: Instant,
        val endTime: Instant,
        val avgBpm: Long,
        val maxBpm: Long,
        val minBpm: Long,
        val count: Long?
    )

    data class SimpleBpm(
        val maxBpm: Long, val minBpm: Long, val avgBpm: Double
    )

    private fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}