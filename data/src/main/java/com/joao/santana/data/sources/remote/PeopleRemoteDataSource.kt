package com.joao.santana.data.sources.remote

import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.People
import com.joao.santana.domain.entities.response.Response

interface PeopleRemoteDataSource {

    suspend fun people(): Response<Peoples>
    suspend fun people(id: Long): Response<People>
}