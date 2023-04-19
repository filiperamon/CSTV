package com.example.cstv.framework.di

import com.example.core.usecase.GetMatchUseCase
import com.example.core.usecase.GetMatchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindMatchUseCase(useCase: GetMatchUseCaseImpl): GetMatchUseCase
}