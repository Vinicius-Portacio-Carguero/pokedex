package com.example.pokedex.plugin.model.pokehome.repository

import com.example.pokedex.feature.domain.Pokemon
import com.example.pokedex.plugin.model.pokehome.service.PokehomeService
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class PokehomeRepository @Inject constructor( private val service: PokehomeService) {

    fun searchPokemon(pokeName: String) : Call<Pokemon> = service.searchPokemon(pokeName)

}