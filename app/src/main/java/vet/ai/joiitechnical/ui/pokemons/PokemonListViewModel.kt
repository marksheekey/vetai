package vet.ai.joiitechnical.ui.pokemons

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.modules.database.pokemon.PokemonRepo

class PokemonListViewModel @ViewModelInject constructor(
    private val repo: PokemonRepo
) : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    private val disposables = mutableListOf<Disposable>()

    private val _pokemons = MutableLiveData<List<PokemonDTO>>()
    val pokemonsList: LiveData<List<PokemonDTO>> get() = _pokemons

    init {
        disposables.add(
            repo.loadData()
                .subscribe({
                    _pokemons.postValue(it)
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()

        disposables.onEach { it.dispose() }.clear()
    }

    fun favourite(pokemon: PokemonDTO, favourited: Boolean, onComplete: () -> Unit) {
        disposables.add(
            repo.favouritePokemons(pokemon, favourited)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ onComplete() }, {})
        )
    }

    fun filterPokemons(favourited: Boolean) {
        disposables.add(
            repo.filterPokemons(favourited)
                .subscribe({
                    _pokemons.postValue(it)
                }, {
                    it.printStackTrace()
                })
        )
    }
}