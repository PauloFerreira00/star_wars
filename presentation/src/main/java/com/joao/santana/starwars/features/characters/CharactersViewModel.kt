package com.joao.santana.starwars.features.characters

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.domain.entities.response.Response
import com.joao.santana.domain.usecases.CharacterUseCase
import com.joao.santana.infrastructure.helpers.NetworkConnection
import com.joao.santana.starwars.features.base.BaseViewModel

class CharactersViewModel(
    networkConnection: NetworkConnection,
    private val characterUseCase: CharacterUseCase
) : BaseViewModel(networkConnection) {

    val characters: LiveData<Characters> get() = _characters

    private val _characters: MutableLiveData<Characters> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getCharacters()
    }

    private fun getCharacters() {
        launchData { ->
            when (val response = characterUseCase.getCharacters()) {
                is Response.Error -> onError(response.message)
                is Response.Success -> _characters.value = response.body
            }
        }
    }
}