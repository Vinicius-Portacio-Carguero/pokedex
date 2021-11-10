package com.example.pokedex.di

import com.example.pokedex.feature.pokeHome.viewModel.PokehomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PokedexModule::class
    ]
)

interface AppComponent {
    fun inject(app: App)
    fun inject(viewModel: PokehomeViewModel)
}