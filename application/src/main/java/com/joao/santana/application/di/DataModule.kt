package com.joao.santana.application.di

import com.joao.santana.application.di.InfrastructureModule.INTERCEPTOR_HELPER
import com.joao.santana.application.di.InfrastructureModule.MOSHI_HELPER
import com.joao.santana.data.mappers.CharacterResponseToCharacter
import com.joao.santana.data.mappers.CharactersResponseToCharacters
import com.joao.santana.data.repositories.CharacterRepositoryImpl
import com.joao.santana.data.sources.remote.CharacterRemoteDataSource
import com.joao.santana.data.sources.remote.CharacterRemoteDataSourceImpl
import com.joao.santana.data.sources.remote.service.CharacterService
import com.joao.santana.domain.repositories.CharacterRepository
import com.joao.santana.infrastructure.builders.RetrofitBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {

    private const val CHARACTER_RESPONSE_TO_CHARACTER: String = "CharacterResponseToCharacter"
    private const val CHARACTERS_RESPONSE_TO_CHARACTERS: String = "CharactersResponseToCharacters"

    val mappers = module { ->

        single(named(CHARACTER_RESPONSE_TO_CHARACTER)) { _ ->
            CharacterResponseToCharacter()
        }

        single(named(CHARACTERS_RESPONSE_TO_CHARACTERS)) { _ ->
            CharactersResponseToCharacters(
                get(named(CHARACTER_RESPONSE_TO_CHARACTER))
            )
        }

    }

    private const val CHARACTER_SERVICE: String = "CharacterService"

    val services = module { ->

        single<CharacterService>(
            named(CHARACTER_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

    }

    private const val CHARACTER_REMOTE_DATA_SOURCE: String = "CharacterRemoteDataSource"

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

    }

    const val CHARACTER_REPOSITORY: String = "CharacterRepository"

    val repositories = module { ->

        single<CharacterRepository>(
            named(CHARACTER_REPOSITORY)
        ) { _ ->
            CharacterRepositoryImpl(
                get(named(CHARACTER_REMOTE_DATA_SOURCE))
            )
        }

    }
}