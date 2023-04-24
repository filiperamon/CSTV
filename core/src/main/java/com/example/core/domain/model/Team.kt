package com.example.core.domain.model

import com.google.gson.annotations.SerializedName

data class Team (
    val teamId: Int,
    val teamImageUrl: String,
    val teamName: String,
    val players: List<Player?>,
    val slug: String,
)