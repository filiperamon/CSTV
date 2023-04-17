package com.example.core.data.repository

import androidx.paging.PagingSource
import com.example.core.domain.model.Match

interface MatchRepository {
    fun getMatch(query: String) : PagingSource<Int, Match>
}