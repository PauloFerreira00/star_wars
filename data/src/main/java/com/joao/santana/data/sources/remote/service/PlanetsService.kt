package com.joao.santana.data.sources.remote.service

import com.joao.santana.data.models.remote.PlanetResponseBody
import com.joao.santana.data.models.remote.PlanetsResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetsService {

    @GET("planets/")
    fun getPlanets(): Deferred<Response<PlanetsResponseBody>>

    @GET("planets/{planet_id}")
    fun getPlanets(@Path("planet_id") id: Long): Deferred<Response<PlanetResponseBody>>
}