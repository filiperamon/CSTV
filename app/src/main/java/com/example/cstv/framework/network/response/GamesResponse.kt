package com.example.cstv.framework.network.response

import com.example.core.domain.model.Game
import com.google.gson.annotations.SerializedName

data class GamesResponse(
    val id: Long,
)

fun GamesResponse.toGameModel(): Game {
    return Game(
        id = this.id,
    )
}
