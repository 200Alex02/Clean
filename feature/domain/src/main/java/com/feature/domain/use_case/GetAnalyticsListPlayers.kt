package com.feature.domain.use_case

import android.util.Log
import kotlinx.coroutines.delay

class GetAnalyticsListPlayers {

    suspend fun getAnalytics(countPlayers: Int) {
        delay(5000)
        Log.d("tag5", "Было показано: $countPlayers")
    }
}