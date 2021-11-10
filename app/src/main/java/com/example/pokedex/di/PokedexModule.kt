package com.example.pokedex.di

import com.example.pokedex.plugin.model.pokehome.service.PokehomeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
open class PokedexModule {

    val baseUrl = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    @Named("pokehomeRetrofit")
    fun providesRetrofitPokehome(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    open fun providesPokehomeService(@Named("pokehomeRetrofit") retrofit: Retrofit): PokehomeService =
        retrofit.create(PokehomeService::class.java)


}