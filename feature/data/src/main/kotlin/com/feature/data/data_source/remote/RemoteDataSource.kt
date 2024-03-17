package com.feature.data.data_source.remote

import com.feature.data.model.PlayerDto

interface RemoteDataSource {

    fun getRemotePlayers(): List<PlayerDto>
}