package com.joao.santana.starwars.features.starships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.starwars.databinding.FragmentStarShipsBinding
import com.joao.santana.starwars.extensions.bind
import com.joao.santana.starwars.features.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class StarShipsFragment : BaseFragment() {

    private lateinit var adapter: StarShipsAdapter
    private lateinit var binding: FragmentStarShipsBinding

    override val viewModel: StarShipsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStarShipsBinding.inflate(inflater, container, false)

        subscribeUi()
        recyclerViewFactory()

        return binding.root
    }

    private fun subscribeUi() {
        bind(viewModel.loading, ::onLoading)
        bind(viewModel.starShips, ::onGetStarShips)
    }

    private fun recyclerViewFactory() {
        adapter = StarShipsAdapter()
        binding.recyclerViewStarShips.adapter = adapter
    }

    private fun onLoading(loading: Boolean) {
        if (loading) {
            binding.constraintProgressBar.visibility = VISIBLE
        } else {
            binding.constraintProgressBar.visibility = GONE
        }
    }

    private fun onGetStarShips(starShips: StarShips) {
        starShips.results?.let { adapter.submitList(it) }
    }
}
