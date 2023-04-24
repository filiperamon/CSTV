package com.example.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.Team
import com.example.core.usecase.GetTeamUseCase.GetTeamParam
import com.example.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetTeamUseCase {

    operator fun invoke(params: GetTeamParam): Flow<PagingData<Team>>

    data class GetTeamParam(val query: String, val pagingConfig: PagingConfig)
}

class GetTeamUseCaseImpl @Inject constructor(
    private val teamRepository: TeamRepository
) : PagingUseCase<GetTeamParam, Team>(), GetTeamUseCase {

    override fun createFlowObservable(params: GetTeamParam): Flow<PagingData<Team>> {
        return Pager(config = params.pagingConfig) {
            teamRepository.getTeam(params.query)
        }.flow
    }

}