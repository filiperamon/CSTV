package com.example.cstv.framework.network.response

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("games") val games: List<GamesResponse>,
    @SerializedName("league") val league: LeagueResponse,
    @SerializedName("opponents") val opponentsMatch: List<OpponentMatchResponse>,

)
