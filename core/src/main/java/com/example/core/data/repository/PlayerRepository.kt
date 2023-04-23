package com.example.core.data.repository

import com.example.core.domain.model.Player

interface PlayerRepository {

    fun getPlayer(queries: Map<String, String>) : List<Player>

}