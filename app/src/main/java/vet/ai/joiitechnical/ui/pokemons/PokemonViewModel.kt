package vet.ai.joiitechnical.ui.pokemons

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.modules.database.pokemon.PokemonRepo

class PokemonViewModel @ViewModelInject constructor(private val pokemonRepo: PokemonRepo) :
    ViewModel() {

    fun favourite(pokemon: PokemonDTO, favourited: Boolean, onComplete: () -> Unit) {
        pokemonRepo.favouritePokemons(pokemon, favourited)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onComplete()
            }, {
                it.printStackTrace()
            })
    }

    fun listenToUpdate(pokemon: PokemonDTO): Maybe<PokemonDTO> {
        return pokemonRepo.listenToPokemonUpdates(pokemon.id)
    }
}