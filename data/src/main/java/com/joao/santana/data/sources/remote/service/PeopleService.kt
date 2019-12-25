package com.joao.santana.data.sources.remote.service

import com.joao.santana.data.models.remote.PeopleResponseBody
import com.joao.santana.data.models.remote.PeoplesResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleService {

    @GET("people/")
    fun getPeople() : Deferred<Response<PeoplesResponseBody>>

    @GET("people/{people_id}")
    fun getPeople(@Path("people_id") id: Long) : Deferred<Response<PeopleResponseBody>>
}