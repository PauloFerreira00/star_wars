package com.joao.santana.application.di

import com.joao.santana.application.di.DataModule.CHARACTER_REPOSITORY
import com.joao.santana.application.di.DataModule.PLANETS_REPOSITORY
import com.joao.santana.application.di.DataModule.STAR_SHIPS_REPOSITORY
import com.joao.santana.application.usecases.CharacterUseCaseImpl
import com.joao.santana.application.usecases.PlanetsUseCaseImpl
import com.joao.santana.application.usecases.StarShipsUseCaseImpl
import com.joao.santana.domain.usecases.CharacterUseCase
import com.joao.santana.domain.usecases.PlanetsUseCase
import com.joao.santana.domain.usecases.StarShipsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ApplicationModule {

    const val CHARACTER_USE_CASE: String = "CharacterUseCase"
    const val PLANETS_USE_CASE: String = "PlanetsUseCase"
    const val STAR_SHIPS_USE_CASE: String = "StarShipsUseCase"

    val useCase = module { ->

        single<CharacterUseCase>(
            named(CHARACTER_USE_CASE)
        ) { _ ->
            CharacterUseCaseImpl(
                get(named(CHARACTER_REPOSITORY))
            )
        }

        single<PlanetsUseCase>(
            named(PLANETS_USE_CASE)
        ) { _ ->
            PlanetsUseCaseImpl(
                get(named(PLANETS_REPOSITORY))
            )
        }

        single<StarShipsUseCase>(
            named(STAR_SHIPS_USE_CASE)
        ) { _ ->
            StarShipsUseCaseImpl(
                get(named(STAR_SHIPS_REPOSITORY))
            )
        }

    }
}