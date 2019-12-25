package com.joao.santana.application.di

import com.joao.santana.application.di.InfrastructureModule.INTERCEPTOR_HELPER
import com.joao.santana.application.di.InfrastructureModule.MOSHI_HELPER
import com.joao.santana.data.mappers.PeopleResponseToPeople
import com.joao.santana.data.mappers.PeoplesResponseToPeoples
import com.joao.santana.data.repositories.PeopleRepositoryImpl
import com.joao.santana.data.sources.remote.PeopleRemoteDataSource
import com.joao.santana.data.sources.remote.PeopleRemoteDataSourceImpl
import com.joao.santana.data.sources.remote.service.PeopleService
import com.joao.santana.domain.repositories.PeopleRepository
import com.joao.santana.infrastructure.builders.RetrofitBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {

    private const val PEOPLE_RESPONSE_TO_PEOPLE: String = "PeopleResponseToPeople"
    private const val PEOPLES_RESPONSE_TO_PEOPLES: String = "PeoplesResponseToPeoples"

    val mappers = module { ->

        single(named(PEOPLE_RESPONSE_TO_PEOPLE)) { _ ->
            PeopleResponseToPeople()
        }

        single(named(PEOPLES_RESPONSE_TO_PEOPLES)) { _ ->
            PeoplesResponseToPeoples(
                get(named(PEOPLE_RESPONSE_TO_PEOPLE))
            )
        }

    }

    private const val PEOPLE_SERVICE: String = "PeopleService"

    val services = module { ->

        single<PeopleService>(
            named(PEOPLE_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

    }

    private const val PEOPLE_REMOTE_DATA_SOURCE: String = "PeopleRemoteDataSource"

    val dataSources = module { ->

        single<PeopleRemoteDataSource>(
            named(PEOPLE_REMOTE_DATA_SOURCE)
        ) { _ ->
            PeopleRemoteDataSourceImpl(
                get(named(PEOPLE_SERVICE)),
                get(named(PEOPLE_RESPONSE_TO_PEOPLE)),
                get(named(PEOPLES_RESPONSE_TO_PEOPLES))
            )
        }

    }

    const val PEOPLE_REPOSITORY: String = "PeopleRepository"

    val repositories = module { ->

        single<PeopleRepository>(
            named(PEOPLE_REPOSITORY)
        ) { _ ->
            PeopleRepositoryImpl(
                get(named(PEOPLE_REMOTE_DATA_SOURCE))
            )
        }

    }
}