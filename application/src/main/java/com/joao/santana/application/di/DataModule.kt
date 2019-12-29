package com.joao.santana.application.di

import com.joao.santana.application.di.InfrastructureModule.INTERCEPTOR_HELPER
import com.joao.santana.application.di.InfrastructureModule.MOSHI_HELPER
import com.joao.santana.data.mappers.CharacterResponseToCharacter
import com.joao.santana.data.mappers.CharactersResponseToCharacters
import com.joao.santana.data.mappers.StarShipResponseToStarShip
import com.joao.santana.data.mappers.StarShipsResponseToStarShips
import com.joao.santana.data.repositories.CharacterRepositoryImpl
import com.joao.santana.data.repositories.StarShipsRepositoryImpl
import com.joao.santana.data.sources.remote.CharacterRemoteDataSource
import com.joao.santana.data.sources.remote.CharacterRemoteDataSourceImpl
import com.joao.santana.data.sources.remote.StarShipsRemoteDataSource
import com.joao.santana.data.sources.remote.StarShipsRemoteDataSourceImpl
import com.joao.santana.data.sources.remote.service.CharacterService
import com.joao.santana.data.sources.remote.service.StarShipsService
import com.joao.santana.domain.repositories.CharacterRepository
import com.joao.santana.domain.repositories.StarShipsRepository
import com.joao.santana.infrastructure.builders.RetrofitBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {

    private const val CHARACTER_RESPONSE_TO_CHARACTER: String = "CharacterResponseToCharacter"
    private const val CHARACTERS_RESPONSE_TO_CHARACTERS: String = "CharactersResponseToCharacters"
    private const val STAR_SHIP_RESPONSE_TO_STAR_SHIP: String = "StarShipResponseToStarShip"
    private const val STAR_SHIPS_RESPONSE_TO_STAR_SHIPS: String = "StarShipsResponseToStarShips"

    val mappers = module { ->

        single(named(CHARACTER_RESPONSE_TO_CHARACTER)) { _ ->
            CharacterResponseToCharacter()
        }

        single(named(CHARACTERS_RESPONSE_TO_CHARACTERS)) { _ ->
            CharactersResponseToCharacters(
                get(named(CHARACTER_RESPONSE_TO_CHARACTER))
            )
        }

        single(named(STAR_SHIP_RESPONSE_TO_STAR_SHIP)) { _ ->
            StarShipResponseToStarShip()
        }

        single(named(STAR_SHIPS_RESPONSE_TO_STAR_SHIPS)) { _ ->
            StarShipsResponseToStarShips(
                get(named(STAR_SHIP_RESPONSE_TO_STAR_SHIP))
            )
        }

    }

    private const val CHARACTER_SERVICE: String = "CharacterService"
    private const val STAR_SHIPS_SERVICE: String = "StarShipsService"

    val services = module { ->

        single<CharacterService>(
            named(CHARACTER_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

        single<StarShipsService>(
            named(STAR_SHIPS_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

    }

    private const val CHARACTER_REMOTE_DATA_SOURCE: String = "CharacterRemoteDataSource"
    private const val STAR_SHIPS_REMOTE_DATA_SOURCE: String = "StarShipsRemoteDataSource"

    val dataSources = module { ->

        single<CharacterRemoteDataSource>(
            named(CHARACTER_REMOTE_DATA_SOURCE)
        ) { _ ->
            CharacterRemoteDataSourceImpl(
                get(named(CHARACTER_SERVICE)),
                get(named(CHARACTER_RESPONSE_TO_CHARACTER)),
                get(named(CHARACTERS_RESPONSE_TO_CHARACTERS))
            )
        }

        single<StarShipsRemoteDataSource>(
            named(STAR_SHIPS_REMOTE_DATA_SOURCE)
        ) { _ ->
            StarShipsRemoteDataSourceImpl(
                get(named(STAR_SHIPS_SERVICE)),
                get(named(STAR_SHIP_RESPONSE_TO_STAR_SHIP)),
                get(named(STAR_SHIPS_RESPONSE_TO_STAR_SHIPS))
            )
        }

    }

    const val CHARACTER_REPOSITORY: String = "CharacterRepository"
    const val STAR_SHIPS_REPOSITORY: String = "StarShipsRepository"

    val repositories = module { ->

        single<CharacterRepository>(
            named(CHARACTER_REPOSITORY)
        ) { _ ->
            CharacterRepositoryImpl(
                get(named(CHARACTER_REMOTE_DATA_SOURCE))
            )
        }

        single<StarShipsRepository>(
            named(STAR_SHIPS_REPOSITORY)
        ) { _ ->
            StarShipsRepositoryImpl(
                get(named(STAR_SHIPS_REMOTE_DATA_SOURCE))
            )
        }

    }
}