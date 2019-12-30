package com.joao.santana.data.repositories

import com.joao.santana.data.sources.remote.PlanetsRemoteDataSource
import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.Planet
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.PlanetsRepository

class PlanetsRepositoryImpl(
    private val planetsRemoteDataSource: PlanetsRemoteDataSource
) : PlanetsRepository {

    override suspend fun getPlanets(): Response<Planets> {
        return planetsRemoteDataSource.getPlanets()
    }

    override suspend fun getPlanet(id: Long): Response<Planet> {
        return planetsRemoteDataSource.getPlanet(id)
    }
}