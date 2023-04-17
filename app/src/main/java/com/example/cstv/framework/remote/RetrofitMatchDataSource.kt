package com.example.cstv.framework.remote

import com.example.core.data.repository.MatchRemoteDataSource
import com.example.cstv.framework.network.TvCsApi
import com.example.cstv.framework.network.response.MatchResponse
import javax.inject.Inject

class RetrofitMatchDataSource @Inject constructor(
    private val tvCsApi: TvCsApi
) : MatchRemoteDataSource<MatchResponse> {

    override suspend fun fetchMath(queries: Map<String, String>): MatchResponse {
        return tvCsApi.getMatch(queries)
    }
}