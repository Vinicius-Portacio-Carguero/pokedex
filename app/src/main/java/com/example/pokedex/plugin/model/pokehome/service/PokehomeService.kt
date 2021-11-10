package com.example.pokedex.plugin.model.pokehome.service

import com.example.pokedex.feature.domain.Pokemon
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface PokehomeService {

    @GET("pokemon/{name}")
    fun searchPokemon( @Path("name") name: String ): Call<Pokemon>

}