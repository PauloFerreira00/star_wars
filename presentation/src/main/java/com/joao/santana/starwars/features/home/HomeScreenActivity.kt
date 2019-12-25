package com.joao.santana.starwars.features.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.joao.santana.domain.aggregate.Peoples
import com.joao.santana.starwars.R
import com.joao.santana.starwars.databinding.ActivityHomeScreenBinding
import com.joao.santana.starwars.extensions.bind
import com.joao.santana.starwars.features.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreenActivity : BaseActivity() {

    lateinit var binding: ActivityHomeScreenBinding

    override val viewModel: HomeScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
        binding.viewModel = viewModel

        viewModel.getPeople()
        subscribeUi()
    }

    private fun subscribeUi() {
        bind(viewModel.people, ::onGetPeople)
    }

    private fun onGetPeople(people: Peoples) {
        println(people)
    }
}
