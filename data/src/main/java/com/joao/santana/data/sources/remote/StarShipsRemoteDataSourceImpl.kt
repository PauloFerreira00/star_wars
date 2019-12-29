package com.joao.santana.data.sources.remote

import com.joao.santana.data.extensions.mapToResponseEntity
import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.StarShipResponseBody
import com.joao.santana.data.models.remote.StarShipsResponseBody
import com.joao.santana.data.sources.remote.service.StarShipsService
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip
import com.joao.santana.domain.entities.response.Response

class StarShipsRemoteDataSourceImpl(
    private val starShipsService: StarShipsService,
    private val starShipResponseToStarShip: BaseMapper<StarShipResponseBody, StarShip>,
    private val starShipsResponseToStarShips: BaseMapper<StarShipsResponseBody, StarShips>
) : StarShipsRemoteDataSource {

    override suspend fun getStarShips(): Response<StarShips> {
        return starShipsService.getStarShips().await()
            .mapToResponseEntity(starShipsResponseToStarShips)
    }

    override suspend fun getStarShip(id: Long): Response<StarShip> {
        return starShipsService.getStarShip(id).await()
            .mapToResponseEntity(starShipResponseToStarShip)
    }
}