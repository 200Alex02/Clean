package com.feature.domain.di

import com.feature.domain.use_case.GetPlayersUseCase
import com.feature.domain.use_case.SendAnalyticsListPlayersUseCase
import com.feature.domain.use_case_impl.SendAnalyticsListPlayersUseCaseImpl
import com.feature.domain.use_case_impl.GetPlayersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface DomainLayerModule {

    @Binds
    fun bindPlayersUseCase(impl: GetPlayersUseCaseImpl): GetPlayersUseCase

    @Binds
    fun bindSendAnalyticsListPlayersUseCase(impl: SendAnalyticsListPlayersUseCaseImpl): SendAnalyticsListPlayersUseCase

}