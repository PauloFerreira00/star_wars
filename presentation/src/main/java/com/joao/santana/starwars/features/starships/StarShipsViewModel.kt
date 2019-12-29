package com.joao.santana.starwars.features.starships

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.usecases.StarShipsUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class StarShipsViewModel(
    networkConnection: NetworkConnection,
    private val starShipsUseCase: StarShipsUseCase
) : BaseViewModel(networkConnection) {

    val starShips: LiveData<StarShips> get() = _starShips

    private val _starShips: MutableLiveData<StarShips> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getStarShips()
    }

    private fun getStarShips() {
        launchData { ->
            when (val response = starShipsUseCase.getStarShips()) {
                is Response.Error -> onError(response.message)
                is Response.Success -> _starShips.value = response.body
            }
        }
    }
}