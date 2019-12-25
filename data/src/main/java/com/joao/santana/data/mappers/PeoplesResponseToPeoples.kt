package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PeoplesResponseBody
import com.joao.santana.domain.aggregate.Peoples

class PeoplesResponseToPeoples(
    private val peopleResponseToPeople: PeopleResponseToPeople
) : BaseMapper<PeoplesResponseBody, Peoples> {

    override fun map(input: PeoplesResponseBody): Peoples {
        return Peoples(
            input.count,
            input.next,
            input.previous,
            input.results?.map { peopleResponseToPeople.map(it) }
        )
    }
}