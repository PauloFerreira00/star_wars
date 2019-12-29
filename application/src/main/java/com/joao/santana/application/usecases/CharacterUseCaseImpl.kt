package com.joao.santana.application.usecases

import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.CharacterRepository
import com.joao.santana.domain.usecases.CharacterUseCase

class CharacterUseCaseImpl(
    private val characterRepository: CharacterRepository
) : CharacterUseCase {

    override suspend fun getCharacters(): Response<Characters> {
        return characterRepository.getCharacters()
    }

    override suspend fun getCharacter(id: Long): Response<Character> {
        return characterRepository.getCharacter(id)
    }
}