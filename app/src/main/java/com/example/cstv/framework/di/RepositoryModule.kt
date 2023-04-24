package com.example.cstv.framework.di

import com.example.core.data.repository.MatchRemoteDataSource
import com.example.core.data.repository.MatchRepository
import com.example.core.data.repository.TeamRemoteDataSource
import com.example.core.data.repository.TeamRepository
import com.example.cstv.framework.repoitory.MatchRepositoryImpl
import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.network.response.PlayerResponse
import com.example.cstv.framework.network.response.TeamResponse
import com.example.cstv.framework.remote.RetrofitMatchDataSource
import com.example.cstv.framework.remote.RetrofitTeamDataSource
import com.example.cstv.framework.repoitory.TeamRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    //Repository

    @Binds
    fun bindMatchRepository(repository: MatchRepositoryImpl) : MatchRepository

    @Binds
    fun bindPlayerRepository(repositoryImpl: TeamRepositoryImpl) : TeamRepository

    //Repository

    //DataSource

    @Binds
    fun bindRemoteMatchDataSource(
        dataSource: RetrofitMatchDataSource
    ) : MatchRemoteDataSource<DataWrapperMatchResponse>

    @Binds
    fun bindRemotePlayerDataSource(
        dataSource: RetrofitTeamDataSource
    ) : TeamRemoteDataSource<TeamResponse>

    //DataSource
}