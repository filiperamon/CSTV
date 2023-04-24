package com.example.core.data.repository

import androidx.paging.PagingSource
import com.example.core.domain.model.Team

interface TeamRepository {

    fun getTeam(query: String) : PagingSource<Int, Team>

}