package com.example.core.domain.model

import com.google.gson.annotations.SerializedName

data class Game(
    val beginAt: String,
    val complete: Boolean,
    val finished: Boolean,
    val id: Long,
    val status: String,
)
