package com.joao.santana.data.repositories

import com.joao.santana.data.sources.remote.CharacterRemoteDataSource
import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.repositories.CharacterRepository

class CharacterRepositoryImpl(
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override suspend fun getCharacters(): Response<Characters> {
        return characterRemoteDataSource.getCharacters()
    }

    override suspend fun getCharacter(id: Long): Response<Character> {
        return characterRemoteDataSource.getCharacter(id)
    }
}