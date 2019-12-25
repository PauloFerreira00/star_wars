package com.joao.santana.data.repositories

import com.joao.santana.data.sources.remote.PeopleRemoteDataSource
import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.People
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.PeopleRepository

class PeopleRepositoryImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource
) : PeopleRepository {

    override suspend fun getPeople(): Response<Peoples> {
        return peopleRemoteDataSource.people()
    }

    override suspend fun getPeople(id: Long): Response<People> {
        return peopleRemoteDataSource.people(id)
    }
}