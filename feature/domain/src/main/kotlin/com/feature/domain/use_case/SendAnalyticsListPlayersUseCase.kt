package com.feature.domain.use_case

interface SendAnalyticsListPlayersUseCase {

    suspend fun sendAnalytics(countPlayers: Int)
}