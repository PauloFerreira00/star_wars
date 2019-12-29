package com.joao.santana.data.sources.remote

import com.joao.santana.data.extensions.mapToResponseEntity
import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.CharacterResponseBody
import com.joao.santana.data.models.remote.CharactersResponseBody
import com.joao.santana.data.sources.remote.service.CharacterService
import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character
import com.joao.santana.domain.entities.response.Response

class CharacterRemoteDataSourceImpl(
    private val characterService: CharacterService,
    private val characterResponseToCharacter: BaseMapper<CharacterResponseBody, Character>,
    private val charactersResponseToCharacters: BaseMapper<CharactersResponseBody, Characters>
) : CharacterRemoteDataSource {

    override suspend fun getCharacters(): Response<Characters> {
        return characterService.getCharacters().await()
            .mapToResponseEntity(charactersResponseToCharacters)
    }

    override suspend fun getCharacter(id: Long): Response<Character> {
        return characterService.getCharacter(id).await()
            .mapToResponseEntity(characterResponseToCharacter)
    }
}