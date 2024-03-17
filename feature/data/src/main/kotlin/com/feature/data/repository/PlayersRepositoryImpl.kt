package com.feature.data.repository

import com.feature.data.data_source.local.LocalDataSource
import com.feature.data.data_source.remote.RemoteDataSource
import com.feature.data.mapper.toDomainPlayer
import com.feature.domain.model.Player
import com.feature.domain.repository.PlayersRepository
import javax.inject.Inject


internal class PlayersRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PlayersRepository {

    override suspend fun getListPlayers(): List<Player> {
        val remoteData = remoteDataSource.getRemotePlayers()
        localDataSource.savePlayers(remoteData)
        val cashData = localDataSource.getPlayersFromCash()
        return remoteData.ifEmpty { cashData }.map { it.toDomainPlayer() }
    }
}