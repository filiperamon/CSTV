package com.example.cstv.framework.network.response

import com.example.core.domain.model.Game
import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("begin_at") val beginAt: String,
    val complete: Boolean,
    @SerializedName("detailed_stats") val detailedStats: Boolean,
    val finished: Boolean,
    val id: Long,
    @SerializedName("match_id") val matchId: Long,
    val position: Long,
    val status: String,
)

fun GamesResponse.toGameModel(): Game {
    return Game(
        beginAt = this.beginAt,
        complete = this.complete,
        finished = this.finished,
        id = this.id,
        status = this.status,
    )
}
