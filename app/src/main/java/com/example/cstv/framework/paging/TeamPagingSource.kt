package com.example.cstv.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.core.data.repository.TeamRemoteDataSource
import com.example.core.domain.model.Team
import com.example.cstv.framework.network.response.TeamResponse
import com.example.cstv.framework.network.response.toTeamModel

class TeamPagingSource(
    private val remoteDataSource: TeamRemoteDataSource<TeamResponse>
) : PagingSource<Int, Team>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Team> {
        return try {
            val nextPage = params.key ?: 0

            val queries = hashMapOf(
                "filter[name]" to "snowiee"
            )

            val response = remoteDataSource.fetchTeam(queries)

            LoadResult.Page(
                data = response.map { it.toTeamModel() },
                null,
                nextPage + 1
            )

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Team>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.nextKey?.plus(50) ?: anchorPage?.nextKey?.minus(50)
        }
    }
}
