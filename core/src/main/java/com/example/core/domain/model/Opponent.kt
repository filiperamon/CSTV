package com.example.core.domain.model

import com.google.gson.annotations.SerializedName

data class Opponent(
    val id: Long,
    val imageUrl: String? = "",
    val name: String,
)
