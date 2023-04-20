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
            val nextPage = params.key ?: 0

            val queries = hashMapOf(
                "sort" to "-status",
                "page" to nextPage.toString(),
            )

            val response = remoteDataSource.fetchMath(queries)

            LoadResult.Page(
                data = response.map { it.toMatchModel() },
                null,
                nextPage + 1
            )

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.nextKey?.plus(50) ?: anchorPage?.nextKey?.minus(50)
        }
    }
}
