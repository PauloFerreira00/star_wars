package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.StarShipResponseBody
import com.joao.santana.data.models.remote.StarShipsResponseBody
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.StarShip

class StarShipsResponseToStarShips(
    private val starShipResponseToStarShip: BaseMapper<StarShipResponseBody, StarShip>
) : BaseMapper<StarShipsResponseBody, StarShips> {

    override fun map(input: StarShipsResponseBody): StarShips {
        return StarShips(
            input.count,
            input.next,
            input.previous,
            input.results?.map { starShipResponseToStarShip.map(it) }
        )
    }
}