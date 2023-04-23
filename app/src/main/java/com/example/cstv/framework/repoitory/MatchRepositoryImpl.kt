package com.example.cstv.framework.repoitory

import androidx.paging.PagingSource
import com.example.core.data.repository.MatchRemoteDataSource
import com.example.core.data.repository.MatchRepository
import com.example.core.domain.model.Match
import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.paging.MatchPagingSource
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MatchRemoteDataSource<DataWrapperMatchResponse>
) : MatchRepository {

    override fun getMatch(query: String): PagingSource<Int, Match> {
        return MatchPagingSource(remoteDataSource)
    }
}