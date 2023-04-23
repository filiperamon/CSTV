package com.example.cstv.framework.network

import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.network.response.PlayerResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TvCsApi {
    @GET("matches")
    suspend fun getMatch(
        @QueryMap
        queries: Map<String, String>
    ) : ArrayList<DataWrapperMatchResponse>

    @GET("players")
    suspend fun getPlayer(
        @QueryMap
        queries: Map<String, String>
    ) : ArrayList<PlayerResponse>
}