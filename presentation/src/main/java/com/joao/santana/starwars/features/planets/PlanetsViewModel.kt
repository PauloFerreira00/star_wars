package com.joao.santana.starwars.features.planets

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.usecases.PlanetsUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class PlanetsViewModel(
    networkConnection: NetworkConnection,
    private val planetsUseCase: PlanetsUseCase
) : BaseViewModel(networkConnection) {

    val planets: LiveData<Planets> get() = _planets

    private val _planets: MutableLiveData<Planets> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getPlanets()
    }

    private fun getPlanets() {
        launchData { ->
            when (val response = planetsUseCase.getPlanets()) {
                is Response.Error -> onError(response.message)
                is Response.Success -> _planets.value = response.body
            }
        }
    }
}