package com.feature.data.di

import android.app.Application
import com.feature.data.data_source.local.LocalDataSource
import com.feature.data.data_source.remote.RemoteDataSource
import com.feature.data.repository.GetPlayersRepositoryImpl
import com.feature.domain.repository.PlayersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataDependenciesModule {

    @Provides
    @Singleton
    internal fun provideLocalDataSource(
        application: Application
    ): LocalDataSource {
        return LocalDataSource(application)
    }

    @Provides
    @Singleton
    internal fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSource()
    }

    @Provides
    @Singleton
    internal fun providePlayersRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): PlayersRepository {
        return GetPlayersRepositoryImpl(localDataSource, remoteDataSource)
    }
}