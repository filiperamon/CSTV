package com.example.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.repository.MatchRepository
import com.example.core.domain.model.Match
import com.example.core.usecase.GetMatchUseCase.GetMatchParams
import com.example.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetMatchUseCase {
    operator fun invoke(params: GetMatchParams): Flow<PagingData<Match>>

    data class GetMatchParams(val query: String, val pagingConfig: PagingConfig)
}

class GetMatchUseCaseImpl @Inject constructor(
    private val matchRepository: MatchRepository
): PagingUseCase<GetMatchParams, Match>(), GetMatchUseCase {

    override fun createFlowObservable(params: GetMatchParams): Flow<PagingData<Match>> {
        return Pager(config = params.pagingConfig) {
            matchRepository.getMatch(params.query)
        }.flow
    }
}