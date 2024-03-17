package com.feature.data.repository

import com.feature.data.data_source.local.LocalDataSource
import com.feature.data.data_source.remote.RemoteDataSource
import com.feature.data.mapper.toDomainPlayer
import com.feature.domain.model.Player
import com.feature.domain.repository.PlayersRepository
import com.feature.domain.util.Resource
import javax.inject.Inject


internal class PlayersRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PlayersRepository {

    override suspend fun getListPlayers(): Resource<List<Player>> {
        return try {
            val remoteData = remoteDataSource.getRemotePlayers()
            localDataSource.savePlayers(remoteData)
            Resource.Success(remoteData.map { playerDto -> playerDto.toDomainPlayer() })
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getListPlayersFromCash(): Resource<List<Player>> {
        val cashData = localDataSource.getPlayersFromCash()
        return Resource.Success(cashData.map { playerDto -> playerDto.toDomainPlayer() })
    }
}