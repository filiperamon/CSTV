package com.example.cstv.framework.repoitory

import com.example.core.data.repository.PlayerRemoteDataSource
import com.example.core.data.repository.PlayerRepository
import com.example.core.domain.model.Player
import com.example.cstv.framework.network.response.PlayerResponse
import com.example.cstv.framework.network.response.toPlayerModel
import java.util.concurrent.Flow
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val remoteDataSource: PlayerRemoteDataSource<PlayerResponse>
) : PlayerRepository {

    override fun getPlayer(queries: Map<String, String>): List<Player> {
        TODO("Not yet implemented")
    }


}