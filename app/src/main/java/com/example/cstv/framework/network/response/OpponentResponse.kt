package com.example.cstv.framework.network.response

import com.google.gson.annotations.SerializedName

data class OpponentResponse(
    val id: Long,
    @SerializedName("image_url") val imageUrl: String?,
    val location: String,
    @SerializedName("modified_at") val modifiedAt: String,
    val name: String,
    val slug: String,
)