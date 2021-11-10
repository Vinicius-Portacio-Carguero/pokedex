package com.example.pokedex.feature.pokeHome.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.pokedex.di.App
import com.example.pokedex.feature.domain.Pokemon
import com.example.pokedex.feature.domain.Sprites
import com.example.pokedex.plugin.model.pokehome.repository.PokehomeRepository

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject


class PokehomeViewModel(application: Application) : AndroidViewModel(application) {

    init {
        getApplication<App>().component.inject(this)
    }

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon>
        get() = _pokemon

    private val _notFound = MutableLiveData<Boolean>()
    val notFound: LiveData<Boolean>
    get() = _notFound

    @Inject lateinit var repository: PokehomeRepository

    fun searchPokemon(pokeName: String){
        viewModelScope.launch {

            val result = repository.searchPokemon(pokeName)

            result.enqueue(object : Callback<Pokemon> {
                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {

                    if(!response.body().toString().isNullOrBlank()){
                        _pokemon.postValue(
                            Pokemon(
                                name = response.body()?.name.toString(),
                                Sprites(imgUrl = response.body()?.sprites?.imgUrl.toString())
                            )
                        )

                    }

                    if ( response.code() != 200){
                        _notFound.postValue(true)
                    }

                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {

                }
            })
        }
    }
}
