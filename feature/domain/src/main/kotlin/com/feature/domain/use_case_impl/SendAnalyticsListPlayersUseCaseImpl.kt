package com.feature.domain.use_case_impl

import android.util.Log
import com.feature.domain.use_case.SendAnalyticsListPlayersUseCase
import kotlinx.coroutines.delay
import javax.inject.Inject

internal class SendAnalyticsListPlayersUseCaseImpl @Inject constructor() : SendAnalyticsListPlayersUseCase {

    override suspend fun sendAnalytics(countPlayers: Int) {
        delay(5000)
        Log.d("tag5", "Было показано: $countPlayers")
    }
}