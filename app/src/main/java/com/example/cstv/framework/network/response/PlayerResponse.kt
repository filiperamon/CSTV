package com.example.cstv.framework.network.response

import com.example.core.domain.model.Player
import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("name") val nickName: String,
    val firstName: String,
    val lastName: String
)

fun PlayerResponse.toPlayerModel() : Player {
    return Player(
        nickName = this.nickName,
        firstName = this.firstName,
        lastName = this.lastName,
    )
}
