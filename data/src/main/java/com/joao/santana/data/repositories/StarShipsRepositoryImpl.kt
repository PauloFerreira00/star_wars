package com.joao.santana.data.repositories

import com.joao.santana.data.sources.remote.StarShipsRemoteDataSource
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.StarShipsRepository

class StarShipsRepositoryImpl(
    private val starShipsRemoteDataSource: StarShipsRemoteDataSource
) : StarShipsRepository {

    override suspend fun getStarShips(): Response<StarShips> {
        return starShipsRemoteDataSource.getStarShips()
    }

    override suspend fun getStarShip(id: Long): Response<StarShip> {
        return starShipsRemoteDataSource.getStarShip(id)
    }
}