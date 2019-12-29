package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.CharacterResponseBody
import com.joao.santana.domain.entities.Character

class CharacterResponseToCharacter : BaseMapper<CharacterResponseBody, Character> {

    override fun map(input: CharacterResponseBody): Character {
        return Character(
            input.name,
            input.mass,
            input.height,
            input.gender
        )
    }
}