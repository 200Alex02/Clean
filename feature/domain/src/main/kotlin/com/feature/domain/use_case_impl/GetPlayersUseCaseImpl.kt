package com.feature.domain.use_case_impl

import com.feature.domain.model.Player
import com.feature.domain.repository.PlayersRepository
import com.feature.domain.use_case.GetPlayersUseCase
import com.feature.domain.util.Resource
import javax.inject.Inject

internal class GetPlayersUseCaseImpl @Inject constructor(
    private val repository: PlayersRepository
): GetPlayersUseCase {
    override suspend fun execute(): Resource<List<Player>> {
        return try {
            repository.getListPlayers()
        } catch (e: Exception) {
            repository.getListPlayersFromCash()
        }
    }
}