package com.joao.santana.domain.usecases

import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response

interface CharacterUseCase {

    suspend fun getCharacters(): Response<Characters>
    suspend fun getCharacter(id: Long): Response<Character>
}