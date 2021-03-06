package com.joao.santana.starwars.features.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.joao.santana.starwars.extensions.bind
import org.koin.core.KoinComponent

abstract class BaseFragment : Fragment(), KoinComponent {

    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel)
        subscribeUI()
    }

    private fun subscribeUI() {
        bind(viewModel.error, ::onError)
        bind(viewModel.success, ::onSuccess)
    }

    private fun onError(message: String) {
        println(message)
    }

    private fun onSuccess(message: String) {
        println(message)
    }
}