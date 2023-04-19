package com.example.cstv.framework.network

import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TvCsApi {
    @GET("matches")
    suspend fun getMatch(
        @QueryMap
        queries: Map<String, String>
    ) : DataWrapperMatchResponse
}