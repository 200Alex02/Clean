package com.feature.data.data_source.local

import com.feature.data.model.PlayerDto

interface LocalDataSource {

    fun getPlayersFromCash(): List<PlayerDto>
    fun savePlayers(players: List<PlayerDto>)
}