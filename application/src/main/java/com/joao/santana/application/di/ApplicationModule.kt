package com.joao.santana.application.di

import com.joao.santana.application.di.DataModule.PEOPLE_REPOSITORY
import com.joao.santana.application.usecases.PeopleUseCaseImpl
import com.joao.santana.domain.usecases.PeopleUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ApplicationModule {

    const val PEOPLE_USE_CASE: String = "PeopleUseCase"

    val useCase = module { ->

        single<PeopleUseCase>(
            named(PEOPLE_USE_CASE)
        ) { _ ->
            PeopleUseCaseImpl(
                get(named(PEOPLE_REPOSITORY))
            )
        }

    }
}