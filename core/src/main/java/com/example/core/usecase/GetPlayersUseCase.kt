package com.example.core.usecase

import com.example.core.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface GetPlayersUseCase{
    suspend operator fun invoke(): Flow<List<Player>>
}