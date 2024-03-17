package com.feature.data.repository

import com.feature.data.data_source.local.LocalDataSource
import com.feature.data.data_source.remote.RemoteDataSource
import com.feature.data.data_source.remote.listPlayers
import com.feature.data.mapper.toDomainPlayer
import com.feature.domain.repository.PlayersRepository
import javax.inject.Inject
import kotlin.random.Random


internal class GetPlayersRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PlayersRepository {

    override suspend fun getListPlayers(): List<com.feature.domain.model.Player> {
        val players = if (Random.nextBoolean()) {
            localDataSource.getPlayersFromCash()
        } else {
            localDataSource.savePlayers(listPlayers)
            remoteDataSource.getRemotePlayers()
        }
        return players.map { it.toDomainPlayer() }
    }
}