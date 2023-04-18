package com.example.cstv.framework.network.response

import com.google.gson.annotations.SerializedName

data class OpponentMatchResponse(
    @SerializedName("opponent") val match: OpponentResponse?,
    val type: String,
)
