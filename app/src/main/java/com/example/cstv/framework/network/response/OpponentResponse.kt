package com.example.cstv.framework.network.response

import com.example.core.domain.model.Opponent
import com.google.gson.annotations.SerializedName

data class OpponentResponse(
    val id: Long,
    @SerializedName("image_url") val imageUrl: String?,
    val location: String,
    @SerializedName("modified_at") val modifiedAt: String,
    val name: String,
    val slug: String,
)

fun OpponentResponse.toOpponentModel() : Opponent {
    return Opponent(
        id = this.id,
        imageUrl = this.imageUrl,
        name = this.name,
    )
}