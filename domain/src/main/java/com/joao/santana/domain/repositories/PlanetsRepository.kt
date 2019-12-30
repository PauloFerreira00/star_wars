package com.joao.santana.domain.repositories

import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.Planet
import com.joao.santana.domain.entities.response.Response

interface PlanetsRepository {

    suspend fun getPlanets(): Response<Planets>
    suspend fun getPlanet(id: Long): Response<Planet>
}