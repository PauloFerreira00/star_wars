package com.joao.santana.application.di

import com.joao.santana.application.di.DataModule.CHARACTER_REPOSITORY
import com.joao.santana.application.usecases.CharacterUseCaseImpl
import com.joao.santana.domain.usecases.CharacterUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ApplicationModule {

    const val CHARACTER_USE_CASE: String = "CharacterUseCase"

    val useCase = module { ->

        single<CharacterUseCase>(
            named(CHARACTER_USE_CASE)
        ) { _ ->
            CharacterUseCaseImpl(
                get(named(CHARACTER_REPOSITORY))
            )
        }

    }
}