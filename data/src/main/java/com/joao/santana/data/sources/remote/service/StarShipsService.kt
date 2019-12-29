package com.joao.santana.data.sources.remote.service

import com.joao.santana.data.models.remote.StarShipResponseBody
import com.joao.santana.data.models.remote.StarShipsResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarShipsService {

    @GET("starships/")
    fun getStarShips(): Deferred<Response<StarShipsResponseBody>>

    @GET("starships/{star_ship_id}")
    fun getStarShip(@Path("star_ship_id") id: Long): Deferred<Response<StarShipResponseBody>>
}