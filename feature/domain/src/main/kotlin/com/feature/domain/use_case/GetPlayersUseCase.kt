package com.feature.domain.use_case

import com.feature.domain.model.Player
import com.feature.domain.util.Resource

interface GetPlayersUseCase {

    suspend fun execute(): Resource<List<Player>>
}