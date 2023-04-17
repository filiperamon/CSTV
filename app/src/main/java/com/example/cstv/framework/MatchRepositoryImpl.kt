package com.example.cstv.framework

import androidx.paging.PagingSource
import com.example.core.data.repository.MatchRemoteDataSource
import com.example.core.data.repository.MatchRepository
import com.example.core.domain.model.Match
import com.example.cstv.framework.network.response.MatchResponse
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MatchRemoteDataSource<MatchResponse>
) : MatchRepository {

    override fun getMatch(query: String): PagingSource<Int, Match> {
        TODO("Not yet implemented")
    }
}