package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.StarShipResponseBody
import com.joao.santana.domain.entities.StarShip

class StarShipResponseToStarShip : BaseMapper<StarShipResponseBody, StarShip> {

    override fun map(input: StarShipResponseBody): StarShip {
        return StarShip(
            input.name
        )
    }
}