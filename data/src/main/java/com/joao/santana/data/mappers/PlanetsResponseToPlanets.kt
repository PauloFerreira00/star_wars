package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PlanetResponseBody
import com.joao.santana.data.models.remote.PlanetsResponseBody
import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.Planet

class PlanetsResponseToPlanets(
    private val planetResponseToPlanet: BaseMapper<PlanetResponseBody, Planet>
) : BaseMapper<PlanetsResponseBody, Planets> {

    override fun map(input: PlanetsResponseBody): Planets {
        return Planets(
            input.count,
            input.next,
            input.previous,
            input.results?.map { planetResponseToPlanet.map(it) }
        )
    }
}