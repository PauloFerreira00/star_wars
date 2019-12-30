package com.joao.santana.starwars.features.planets

import com.joao.santana.domain.usecases.PlanetsUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class PlanetsViewModel(
    networkConnection: NetworkConnection,
    private val planetsUseCase: PlanetsUseCase
) : BaseViewModel(networkConnection) {
}