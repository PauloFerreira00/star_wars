package com.joao.santana.starwars.features.home

import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class HomeScreenViewModel(
    networkConnection: NetworkConnection
) : BaseViewModel(networkConnection)