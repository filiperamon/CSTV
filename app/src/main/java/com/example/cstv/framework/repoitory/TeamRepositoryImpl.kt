package com.example.cstv.framework.repoitory

import androidx.paging.PagingSource
import com.example.core.data.repository.TeamRemoteDataSource
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.Team
import com.example.cstv.framework.network.response.TeamResponse
import com.example.cstv.framework.paging.TeamPagingSource
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val remoteDataSource: TeamRemoteDataSource<TeamResponse>
) : TeamRepository {
    override fun getTeam(query: String): PagingSource<Int, Team> {
        return TeamPagingSource(remoteDataSource)
    }

}