package com.example.core.domain.model

data class Match(
    val league: League,
    val opponent: List<Opponent>,
    val game: Game
)
