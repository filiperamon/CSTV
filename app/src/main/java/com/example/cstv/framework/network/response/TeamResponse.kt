package com.example.cstv.framework.network.response

import com.example.core.domain.model.Team
import com.google.gson.annotations.SerializedName

data class TeamResponse (
    @SerializedName("id") val teamId: Int,
    @SerializedName("image_url") val teamImageUrl: String,
    @SerializedName("name") val teamName: String,
    val players: List<PlayerResponse?>,
    val slug: String,
    )

fun TeamResponse.toTeamModel() : Team {
    return Team(
        teamId = teamId,
        teamImageUrl = teamImageUrl,
        teamName = teamName,
        players = players.map { it?.toPlayerModel() },
        slug = slug
    )
}