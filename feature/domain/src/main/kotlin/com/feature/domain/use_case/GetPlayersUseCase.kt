package com.feature.domain.use_case

import com.feature.domain.model.Player

interface GetPlayersUseCase {

    suspend fun execute(): List<Player>
}