package com.example.pokedex.feature.pokeHome.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.PokehomeFragmentBinding
import com.example.pokedex.feature.domain.Pokemon
import com.example.pokedex.feature.pokeHome.viewModel.PokehomeViewModel
import com.squareup.picasso.Picasso

class PokehomeFragment(): Fragment() {

    private var _binding: PokehomeFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: PokehomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PokehomeFragmentBinding.inflate(inflater, container, false)
        setupViews(view)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews(view: View?){

        val pokeName = binding.fieldPokemon.text.toString()

        registerObserver()

        binding.btnSearch.setOnClickListener { getPokemon(pokeName) }

    }

    private fun registerObserver(){
        viewModel.pokemon.observe(viewLifecycleOwner, pokemonObserve)
        viewModel.notFound.observe(viewLifecycleOwner, notFoundObserve)

    }
    private val pokemonObserve = Observer<Pokemon> { pokemon ->

        Picasso.get().load(pokemon.sprites.imgUrl).into(binding.ivPokemon)
        binding.tvPokename.text = pokemon.name

    }

    private val notFoundObserve = Observer<Boolean> { error ->

        binding.tvPokename.setText(R.string.pokemon_not_found)
        binding.ivPokemon.setImageResource(R.drawable.ic_baseline_erro)

    }

    private fun getPokemon(pokeName: String) {

        viewModel.searchPokemon(binding.fieldPokemon.text.toString())
    }

}