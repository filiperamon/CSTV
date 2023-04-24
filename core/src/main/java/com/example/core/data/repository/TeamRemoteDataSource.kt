package com.example.core.data.repository

interface TeamRemoteDataSource<T> {
    suspend fun fetchTeam(queries: Map<String, String>) : ArrayList<T>
}