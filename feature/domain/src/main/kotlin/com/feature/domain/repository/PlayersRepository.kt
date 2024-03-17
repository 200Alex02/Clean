package com.feature.domain.repository

import com.feature.domain.model.Player
import com.feature.domain.util.Resource

interface PlayersRepository {

    suspend fun getListPlayers(): Resource<List<Player>>

    suspend fun getListPlayersFromCash(): Resource<List<Player>>
}