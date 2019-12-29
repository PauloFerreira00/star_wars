package com.joao.santana.starwars.features.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joao.santana.starwars.extensions.bind
import org.koin.core.KoinComponent

abstract class BaseFragment(
    private val layoutId: Int
) : Fragment(), KoinComponent {

    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel)
        subscribeUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
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