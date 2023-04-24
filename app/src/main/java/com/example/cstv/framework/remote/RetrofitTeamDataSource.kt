package com.example.cstv.framework.remote

import com.example.core.data.repository.TeamRemoteDataSource
import com.example.cstv.framework.network.TvCsApi
import com.example.cstv.framework.network.response.TeamResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrofitTeamDataSource @Inject constructor(
    private val tvCsApi: TvCsApi
) : TeamRemoteDataSource<TeamResponse> {

    override suspend fun fetchTeam(queries: Map<String, String>) : ArrayList<TeamResponse> {
        return tvCsApi.getTeam(queries)
    }

}