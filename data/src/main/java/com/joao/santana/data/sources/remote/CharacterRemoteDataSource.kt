package com.joao.santana.data.sources.remote

import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response

interface CharacterRemoteDataSource {

    suspend fun getCharacters(): Response<Characters>
    suspend fun getCharacter(id: Long): Response<Character>
}