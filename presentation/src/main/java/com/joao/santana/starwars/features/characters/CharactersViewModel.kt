package com.joao.santana.starwars.features.characters

import com.joao.santana.domain.usecases.PeopleUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class CharactersViewModel(
    networkConnection: NetworkConnection,
    private val peopleUseCase: PeopleUseCase
) : BaseViewModel(networkConnection) {


}