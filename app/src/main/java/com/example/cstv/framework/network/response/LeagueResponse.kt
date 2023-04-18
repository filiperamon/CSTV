package com.example.cstv.framework.network.response

import com.example.core.domain.model.League
import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    val id: Long,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("modified_at") val modifiedAt: String,
    val name: String,
    val slug: String,
    val url: String?,
)

fun LeagueResponse.toLeagueModel() : League {
    return League(
        name = this.name,
        imgUrl = this.imageUrl,
    )
}
