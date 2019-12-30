package com.joao.santana.starwars.features.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joao.santana.starwars.R
import com.joao.santana.starwars.features.base.BaseFragment
import com.joao.santana.starwars.features.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlanetsFragment : BaseFragment() {

    override val viewModel: PlanetsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }
}
