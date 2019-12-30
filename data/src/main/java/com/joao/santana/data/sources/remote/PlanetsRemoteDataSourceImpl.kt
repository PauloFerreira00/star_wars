package com.joao.santana.data.sources.remote

import com.joao.santana.data.extensions.mapToResponseEntity
import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PlanetResponseBody
import com.joao.santana.data.models.remote.PlanetsResponseBody
import com.joao.santana.data.sources.remote.service.PlanetsService
import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.Planet
import com.joao.santana.domain.entities.response.Response

class PlanetsRemoteDataSourceImpl(
    private val planetsService: PlanetsService,
    private val planetResponseToPlanet: BaseMapper<PlanetResponseBody, Planet>,
    private val planetsResponseToPlanets: BaseMapper<PlanetsResponseBody, Planets>
) : PlanetsRemoteDataSource {

    override suspend fun getPlanets(): Response<Planets> {
        return planetsService.getPlanets().await()
            .mapToResponseEntity(planetsResponseToPlanets)
    }

    override suspend fun getPlanet(id: Long): Response<Planet> {
        return planetsService.getPlanets(id).await()
            .mapToResponseEntity(planetResponseToPlanet)
    }
}