package com.example.cstv.framework.network.response

import com.example.core.domain.model.Match
import com.google.gson.annotations.SerializedName

data class DataWrapperMatchResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("games") val games: List<GamesResponse>,
    @SerializedName("league") val league: LeagueResponse,
    @SerializedName("opponents") val opponents: List<OpponentMatchResponse>,
    @SerializedName("serie") val serie: SerieResponse,
    @SerializedName("scheduled_at") val date: String,
    @SerializedName("status") val status: String,
)

fun DataWrapperMatchResponse.toMatchModel() : Match {
    return Match(
        id = this.id,
        game = this.games.map { it.toGameModel() },
        league = this.league.toLeagueModel(),
        opponent = this.opponents.map { it.toOpponentModel() },
        serie = this.serie.toSerieModel(),
        date = this.date,
        status = this.status,
    )
}
