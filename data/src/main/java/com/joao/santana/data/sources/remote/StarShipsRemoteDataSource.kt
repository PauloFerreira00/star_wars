package com.joao.santana.data.sources.remote

import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip
import com.joao.santana.domain.entities.response.Response


interface StarShipsRemoteDataSource {

    suspend fun getStarShips(): Response<StarShips>
    suspend fun getStarShip(id: Long): Response<StarShip>
}