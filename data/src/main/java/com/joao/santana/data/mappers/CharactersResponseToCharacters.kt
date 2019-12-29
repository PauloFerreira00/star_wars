package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.CharacterResponseBody
import com.joao.santana.data.models.remote.CharactersResponseBody
import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.Character

class CharactersResponseToCharacters(
    private val characterResponseToCharacter: BaseMapper<CharacterResponseBody, Character>
) : BaseMapper<CharactersResponseBody, Characters> {

    override fun map(input: CharactersResponseBody): Characters {
        return Characters(
            input.count,
            input.next,
            input.previous,
            input.results?.map { characterResponseToCharacter.map(it) }
        )
    }
}