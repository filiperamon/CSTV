package com.example.cstv.framework.remote

import com.example.core.data.repository.MatchRemoteDataSource
import com.example.cstv.framework.network.TvCsApi
import com.example.cstv.framework.network.response.DataWrapperMatchResponse 
import javax.inject.Inject

class RetrofitMatchDataSource @Inject constructor(
    private val tvCsApi: TvCsApi
) : MatchRemoteDataSource<DataWrapperMatchResponse> {

    override suspend fun fetchMath(queries: Map<String, String>): DataWrapperMatchResponse {
        return tvCsApi.getMatch(queries)
    }
}