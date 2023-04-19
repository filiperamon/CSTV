package com.example.core.data.repository

interface MatchRemoteDataSource<T> {
    suspend fun fetchMath(queries: Map<String, String>): ArrayList<T>
}