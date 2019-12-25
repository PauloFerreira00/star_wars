package com.joao.santana.starwars

import android.app.Application
import com.joao.santana.starwars.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class StarWarsApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initInjections()
    }

    private fun initInjections() {
        startKoin { ->
            androidLogger()
            androidContext(this@StarWarsApp)
            modules(AppComponent.allModules())
        }
    }
}