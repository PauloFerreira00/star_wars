package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PlanetResponseBody
import com.joao.santana.domain.entities.Planet

class PlanetResponseToPlanet : BaseMapper<PlanetResponseBody, Planet> {

    override fun map(input: PlanetResponseBody): Planet {
        return Planet(
            input.name
        )
    }
}