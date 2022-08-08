package vet.ai.joiitechnical.ui.pokemons.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDB
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.modules.repos.PokemonRepo
import vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon

class PokemonListViewModel @ViewModelInject constructor(
    private val getNextPageOfPokemon: GerNextPageOfPokemon,
    private val fetchPokemonFromDb: FetchPokemonFromDb
) : ViewModel() {
    companion object {
        const val TAG = "MainViewModel"
    }

    private val _pokemonList = MutableLiveData<List<PokemonListUIItem>>()
    val pokemonList : LiveData<List<PokemonListUIItem>> get() = _pokemonList

    init{
       getNextPage()
    }

    fun getNextPage(){
        viewModelScope.launch(Dispatchers.IO) {
            getNextPageOfPokemon.execute()
            favouriteToggled(false)
        }
    }

    fun favouriteToggled(favouritesOnly : Boolean){
        viewModelScope.launch {
            fetchPokemonFromDb.execute(favouritesOnly).collect{
                _pokemonList.value = it.map{ db ->
                    PokemonListUIItem(db.id,db.name, db.favourited)
                }
            }
        }
    }
}