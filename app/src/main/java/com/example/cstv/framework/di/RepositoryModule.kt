package com.example.cstv.framework.di

import com.example.core.data.repository.MatchRemoteDataSource
import com.example.core.data.repository.MatchRepository
import com.example.core.data.repository.PlayerRemoteDataSource
import com.example.cstv.framework.repoitory.MatchRepositoryImpl
import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.network.response.PlayerResponse
import com.example.cstv.framework.remote.RetrofitMatchDataSource
import com.example.cstv.framework.remote.RetrofitPlayerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMatchRepository(repository: MatchRepositoryImpl) : MatchRepository

    @Binds
    fun bindRemoteMatchDataSource(
        dataSource: RetrofitMatchDataSource
    ) : MatchRemoteDataSource<DataWrapperMatchResponse>

    @Binds
    fun bindRemotePlayerDataSource(
        dataSource: RetrofitPlayerDataSource
    ) : PlayerRemoteDataSource<PlayerResponse>
}