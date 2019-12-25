package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PeopleResponseBody
import com.joao.santana.domain.entities.People

class PeopleResponseToPeople : BaseMapper<PeopleResponseBody, People> {

    override fun map(input: PeopleResponseBody): People {
        return People(
            input.name,
            input.mass,
            input.height,
            input.gender
        )
    }
}