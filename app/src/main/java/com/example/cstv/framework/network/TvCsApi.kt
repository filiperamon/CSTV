package com.example.cstv.framework.network

import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.network.response.TeamResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TvCsApi {
    @GET("matches")
    suspend fun getMatch(
        @QueryMap
        queries: Map<String, String>
    ) : ArrayList<DataWrapperMatchResponse>

    @GET("teams")
    suspend fun getTeam(
        @QueryMap
        queries: Map<String, String>
    ) : ArrayList<TeamResponse>
}