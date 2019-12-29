package com.joao.santana.starwars.features.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.joao.santana.domain.aggregate.Characters
import com.joao.santana.starwars.databinding.FragmentCharactersBinding
import com.joao.santana.starwars.extensions.bind
import com.joao.santana.starwars.features.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {

    private lateinit var adapter: CharactersAdapter
    private lateinit var binding: FragmentCharactersBinding

    override val viewModel: CharactersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)

        subscribeUi()
        recyclerViewFactory()

        return binding.root
    }

    private fun subscribeUi() {
        bind(viewModel.loading, ::onLoading)
        bind(viewModel.characters, ::onGetCharacters)
    }

    private fun recyclerViewFactory() {
        adapter = CharactersAdapter()
        binding.recyclerViewCharacters.adapter = adapter
    }

    private fun onLoading(loading: Boolean) {
        if (loading) {
            binding.constraintProgressBar.visibility = VISIBLE
        } else {
            binding.constraintProgressBar.visibility = GONE
        }
    }

    private fun onGetCharacters(characters: Characters) {
        characters.characters?.let { adapter.submitList(it) }
    }
}
