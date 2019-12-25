package com.joao.santana.starwars.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.usecases.PeopleUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class HomeScreenViewModel(
    networkConnection: NetworkConnection,
    private val peopleUseCase: PeopleUseCase
) : BaseViewModel(networkConnection) {

    val people: LiveData<Peoples> get() = _people

    private val _people: MutableLiveData<Peoples> = MutableLiveData()

    fun getPeople() {
        launchData { ->
            when (val response = peopleUseCase.getPeople()) {
                is Response.Success -> {
                    _people.value = response.body
                }
                is Response.Error -> {
                    onError(response.message)
                }
            }
        }
    }
}