package com.example.cstv.framework.network.response

import com.example.core.domain.model.Opponent
import com.google.gson.annotations.SerializedName

data class OpponentMatchResponse(
    @SerializedName("opponent") val opponent: OpponentResponse?
)

fun OpponentMatchResponse.toOpponentModel(): Opponent {
    return Opponent(
        id = this.opponent!!.id,
        imageUrl = this.opponent.imageUrl,
        name = this.opponent.name
    )
}