package com.joao.santana.domain.aggregate

import com.joao.santana.domain.entities.Planet

data class Planets(
    val count: Long?,
    val next: String?,
    val previous: String?,
    val results: List<Planet>?
)