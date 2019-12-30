package com.joao.santana.starwars.features.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joao.santana.domain.aggregate.Planets
import com.joao.santana.domain.aggregate.StarShips
import com.joao.santana.starwars.databinding.FragmentPlanetsBinding
import com.joao.santana.starwars.extensions.bind
import com.joao.santana.starwars.features.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlanetsFragment : BaseFragment() {

    private lateinit var adapter: PlanetsAdapter
    private lateinit var binding: FragmentPlanetsBinding

    override val viewModel: PlanetsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanetsBinding.inflate(inflater, container, false)

        subscribeUi()
        recyclerViewFactory()

        return binding.root
    }

    private fun subscribeUi() {
        bind(viewModel.loading, ::onLoading)
        bind(viewModel.planets, ::onGetPlanets)
    }

    private fun recyclerViewFactory() {
        adapter = PlanetsAdapter()
        binding.recyclerViewPlanets.adapter = adapter
    }

    private fun onLoading(loading: Boolean) {
        if (loading) {
            binding.constraintProgressBar.visibility = View.VISIBLE
        } else {
            binding.constraintProgressBar.visibility = View.GONE
        }
    }

    private fun onGetPlanets(planets: Planets) {
        planets.results?.let { adapter.submitList(it) }
    }
}
