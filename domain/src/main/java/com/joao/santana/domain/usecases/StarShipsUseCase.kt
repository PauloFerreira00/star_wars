package com.joao.santana.domain.usecases

import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip
import com.joao.santana.domain.entities.response.Response

interface StarShipsUseCase {

    suspend fun getStarShips(): Response<StarShips>
    suspend fun getStarShip(id: Long): Response<StarShip>
}