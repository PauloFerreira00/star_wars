package com.joao.santana.starwars.features.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joao.santana.starwars.R
import com.joao.santana.starwars.databinding.ActivityHomeScreenBinding
import com.joao.santana.starwars.extensions.setupToolbar
import com.joao.santana.starwars.features.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreenActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override val viewModel: HomeScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)

        setupToolbar(binding.toolbar, false, getString(R.string.app_name))

        setNavigationController()
    }

    private fun setNavigationController() {
        navController = Navigation.findNavController(this, R.id.navigation_host_fragment)

        bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setupWithNavController(navController)
    }
}
