package com.joao.santana.domain.aggregate

import com.joao.santana.domain.entities.People

data class Peoples(
    val count: Long?,
    val next: String?,
    val previous: String?,
    val peoples: List<People>?
)