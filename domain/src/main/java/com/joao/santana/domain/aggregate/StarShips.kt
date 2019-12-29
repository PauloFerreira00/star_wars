package com.joao.santana.domain.aggregate

import com.joao.santana.domain.entities.StarShip

data class StarShips(
    val count: Long?,
    val next: String?,
    val previous: String?,
    val results: List<StarShip>?
)