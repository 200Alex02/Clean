package com.feature.domain.di

import com.feature.domain.repository.PlayersRepository
import com.feature.domain.use_case.GetAnalyticsListPlayers
import com.feature.domain.use_case.GetPlayersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetPlayersUseCase(repository: PlayersRepository): GetPlayersUseCase {
        return GetPlayersUseCase(repository)
    }

    @Provides
    fun provideGetAnalyticsListPlayersUseCase(): GetAnalyticsListPlayers {
        return GetAnalyticsListPlayers()
    }
}