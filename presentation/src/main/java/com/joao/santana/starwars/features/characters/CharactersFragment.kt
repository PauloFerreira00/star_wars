package com.joao.santana.starwars.features.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joao.santana.starwars.R
import com.joao.santana.starwars.features.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment(R.layout.fragment_characters) {

    override val viewModel: CharactersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeUi()
    }

    private fun subscribeUi() {}
}
