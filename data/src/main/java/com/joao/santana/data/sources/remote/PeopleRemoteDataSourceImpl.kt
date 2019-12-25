package com.joao.santana.data.sources.remote

import com.joao.santana.data.extensions.mapToResponseEntity
import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.PeopleResponseBody
import com.joao.santana.data.models.remote.PeoplesResponseBody
import com.joao.santana.data.sources.remote.service.PeopleService
import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.People
import com.joao.santana.domain.entities.response.Response

class PeopleRemoteDataSourceImpl(
    private val peopleService: PeopleService,
    private val peopleResponseToPeople: BaseMapper<PeopleResponseBody, People>,
    private val peoplesResponseToPeoples: BaseMapper<PeoplesResponseBody, Peoples>
) : PeopleRemoteDataSource {

    override suspend fun people(): Response<Peoples> {
        return peopleService.getPeople().await()
            .mapToResponseEntity(peoplesResponseToPeoples)
    }

    override suspend fun people(id: Long): Response<People> {
        return peopleService.getPeople(id).await()
            .mapToResponseEntity(peopleResponseToPeople)
    }
}