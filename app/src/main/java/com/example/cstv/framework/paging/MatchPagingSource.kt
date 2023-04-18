package com.example.cstv.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.core.data.repository.MatchRemoteDataSource
import com.example.core.domain.model.Match
import com.example.cstv.framework.network.response.DataWrapperMatchResponse
import com.example.cstv.framework.network.response.toMatchModel

class MatchPagingSource(
    private val remoteDataSource: MatchRemoteDataSource<DataWrapperMatchResponse>
) : PagingSource<Int, Match>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Match> {
        return try {
            val size = params.key ?: 0
            val queries = hashMapOf(
                "size" to size.toString()
            )

            val response = remoteDataSource.fetchMath(queries)

            LoadResult.Page(
                data = response.result.map { it.toMatchModel() },
                null,
                null
            )

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.nextKey?.plus(20) ?: anchorPage?.nextKey?.minus(20)
        }
    }
}
