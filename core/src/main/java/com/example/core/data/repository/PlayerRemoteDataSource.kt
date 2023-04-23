package com.example.core.data.repository

interface PlayerRemoteDataSource<T> {
    suspend fun fetchPlayers(queries: Map<String, String>) : ArrayList<T>
}