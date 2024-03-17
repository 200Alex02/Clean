package com.feature.domain.repository

import com.feature.domain.model.Player

interface PlayersRepository {

    suspend fun getListPlayers(): List<Player>
}