package com.example.cstv.framework.network.response

import com.example.core.domain.model.Serie
import com.google.gson.annotations.SerializedName

data class SerieResponse(
    @SerializedName("full_name") val name: String
)

fun SerieResponse.toSerieModel() : Serie {
    return Serie(name = this.name)
}

