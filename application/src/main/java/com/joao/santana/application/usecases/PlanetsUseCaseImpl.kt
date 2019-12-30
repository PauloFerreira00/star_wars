package com.joao.santana.application.usecases

import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.Planet
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.PlanetsRepository
import com.joao.santana.domain.usecases.PlanetsUseCase

class PlanetsUseCaseImpl(
    private val planetsRepository: PlanetsRepository
) : PlanetsUseCase {

    override suspend fun getPlanets(): Response<Planets> {
        return planetsRepository.getPlanets()
    }

    override suspend fun getPlanet(id: Long): Response<Planet> {
        return planetsRepository.getPlanet(id)
    }
}