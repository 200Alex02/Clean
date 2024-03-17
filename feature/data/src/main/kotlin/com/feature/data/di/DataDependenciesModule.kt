package com.feature.data.di

import com.feature.data.data_source.local.LocalDataSource
import com.feature.data.data_source.local.LocalDataSourceImpl
import com.feature.data.data_source.remote.RemoteDataSource
import com.feature.data.data_source.remote.RemoteDataSourceImpl
import com.feature.data.repository.PlayersRepositoryImpl
import com.feature.domain.repository.PlayersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface DataDependenciesModule {

    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    fun bindPlayersRepository(impl: PlayersRepositoryImpl): PlayersRepository

}