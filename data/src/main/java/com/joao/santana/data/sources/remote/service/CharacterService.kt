package com.joao.santana.data.sources.remote.service

import com.joao.santana.data.models.remote.CharacterResponseBody
import com.joao.santana.data.models.remote.CharactersResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("people/")
    fun getCharacters() : Deferred<Response<CharactersResponseBody>>

    @GET("people/{people_id}")
    fun getCharacter(@Path("people_id") id: Long) : Deferred<Response<CharacterResponseBody>>
}