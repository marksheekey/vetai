package vet.ai.joiitechnical.ui.pokemons.one

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vet.ai.joiitechnical.modules.repos.PokemonRepo
import vet.ai.joiitechnical.modules.usecases.FetchOneFromDb
import vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon
import vet.ai.joiitechnical.ui.pokemons.list.PokemonListUIItem

class PokemonViewModel @ViewModelInject constructor(private val fetchOneFromDb: FetchOneFromDb) :
    ViewModel() {

    private val _pokemon  = MutableLiveData<PokemonUIItem>()
    val pokemon: LiveData<PokemonUIItem>  get() = _pokemon

    fun fetchPokemon(id : Int){
        viewModelScope.launch(Dispatchers.IO){
            val db = fetchOneFromDb.execute(id)
            _pokemon.value = PokemonUIItem(db.name, db.favourited, db.url,)
        }
    }
}