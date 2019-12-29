package com.joao.santana.application.usecases

import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.StarShipsRepository
import com.joao.santana.domain.usecases.StarShipsUseCase

class StarShipsUseCaseImpl(
    private val starShipsRepository: StarShipsRepository
) : StarShipsUseCase {

    override suspend fun getStarShips(): Response<StarShips> {
        return starShipsRepository.getStarShips()
    }

    override suspend fun getStarShip(id: Long): Response<StarShip> {
        return starShipsRepository.getStarShip(id)
    }
}