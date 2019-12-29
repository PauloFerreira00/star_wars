package com.joao.santana.domain.aggregate

import com.joao.santana.domain.entities.Character

data class Characters(
    val count: Long?,
    val next: String?,
    val previous: String?,
    val characters: List<Character>?
)