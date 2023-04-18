package com.example.cstv.framework.network.response

import com.example.core.domain.model.Match
import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("games") val games: List<GamesResponse>,
    @SerializedName("league") val league: LeagueResponse,
    @SerializedName("opponents") val opponentsMatch: List<OpponentMatchResponse>,
)

fun MatchResponse.toMatchModel() : Match {
    return Match(
        league = this.league.toLeagueModel(),
        opponent = this.opponentsMatch.takeIf { it.isNotEmpty() }?.map { it.match!!.toOpponentModel() },
        game = this.games.map { it.toGameModel() },
    )
}
