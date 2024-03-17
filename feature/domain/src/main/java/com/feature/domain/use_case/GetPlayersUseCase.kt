package com.feature.domain.use_case

import com.feature.domain.model.Player
import com.feature.domain.repository.PlayersRepository

class GetPlayersUseCase(
    private val repository: PlayersRepository
) {
    suspend fun execute(): List<Player> {
        return repository.getListPlayers()
    }
}