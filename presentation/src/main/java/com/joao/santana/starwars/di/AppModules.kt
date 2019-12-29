package com.joao.santana.starwars.di

import com.joao.santana.application.di.ApplicationModule.CHARACTER_USE_CASE
import com.joao.santana.application.di.ApplicationModule.STAR_SHIPS_USE_CASE
import com.joao.santana.application.di.InfrastructureModule.NETWORK_CONNECTION_HELPER
import com.joao.santana.starwars.features.characters.CharactersViewModel
import com.joao.santana.starwars.features.home.HomeScreenViewModel
import com.joao.santana.starwars.features.starships.StarShipsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModules {

    val viewModel = module { ->

        viewModel { _ ->
            HomeScreenViewModel(
                get(named(NETWORK_CONNECTION_HELPER))
            )
        }

        viewModel { _ ->
            CharactersViewModel(
                get(named(NETWORK_CONNECTION_HELPER)),
                get(named(CHARACTER_USE_CASE))
            )
        }

        viewModel { _ ->
            StarShipsViewModel(
                get(named(NETWORK_CONNECTION_HELPER)),
                get(named(STAR_SHIPS_USE_CASE))
            )
        }

    }

}