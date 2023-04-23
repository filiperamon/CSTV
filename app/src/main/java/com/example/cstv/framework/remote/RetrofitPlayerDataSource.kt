package com.example.cstv.framework.remote

import com.example.core.data.repository.PlayerRemoteDataSource
import com.example.cstv.framework.network.TvCsApi
import com.example.cstv.framework.network.response.PlayerResponse
import javax.inject.Inject

class RetrofitPlayerDataSource @Inject constructor(
    private val tvCsApi: TvCsApi
) : PlayerRemoteDataSource<PlayerResponse> {

    override suspend fun fetchPlayers(queries: Map<String, String>) : ArrayList<PlayerResponse> {
        return tvCsApi.getPlayer(queries)
    }

}