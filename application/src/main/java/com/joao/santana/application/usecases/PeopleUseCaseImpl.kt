package com.joao.santana.application.usecases

import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.People
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.PeopleRepository
import com.joao.santana.domain.usecases.PeopleUseCase

class PeopleUseCaseImpl(
    private val peopleRepository: PeopleRepository
) : PeopleUseCase {

    override suspend fun getPeople(): Response<Peoples> {
        return peopleRepository.getPeople()
    }

    override suspend fun getPeople(id: Long): Response<People> {
        return peopleRepository.getPeople(id)
    }
}