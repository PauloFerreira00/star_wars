package com.joao.santana.domain.usecases

import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.People
import com.joao.santana.domain.entities.response.Response

interface PeopleUseCase {

    suspend fun getPeople(): Response<Peoples>
    suspend fun getPeople(id: Long): Response<People>
}