package com.example.cstv.presentation.match.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.core.domain.model.Team
import com.example.core.usecase.GetTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MatchTeamViewModel @Inject constructor(
    private val getTeamUseCase: GetTeamUseCase
) : ViewModel() {

    fun teamPagingData(query: String): Flow<PagingData<Team>> {
        return getTeamUseCase.invoke(
            GetTeamUseCase.GetTeamParam(query, getPagingConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPagingConfig() = PagingConfig(
        pageSize = 20
    )
}