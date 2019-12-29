package com.joao.santana.domain.repositories

import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response

interface CharacterRepository {

    suspend fun getCharacters(): Response<Characters>
    suspend fun getCharacter(id: Long): Response<Character>
}