package vet.ai.joiitechnical.modules.database.pokemon

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vet.ai.joiitechnical.modules.network.PokemonAPI
import javax.inject.Inject

class PokemonRepo @Inject constructor(private val pokemonDao: PokemonDao, private val pokemonAPI: PokemonAPI) {

    var dataProviderDisposable: Disposable? = null

    private fun getDbPokemons(): Maybe<List<PokemonDTO>> {
        return pokemonDao.getAllPokemonsRx()
            .subscribeOn(Schedulers.io())
            .toObservable()
            .switchMapMaybe {
                if (it.isNotEmpty()) {
                    Maybe.just(it.map { PokemonDTO(it) })
                } else {
                    Maybe.empty()
                }
            }
            .firstElement()
    }

    private fun getApiPokemon(): Single<List<PokemonDTO>> {
        return pokemonAPI.getPokemonList()
            .subscribeOn(Schedulers.io())
            .map {
                it.body()?.pokemons?.map { PokemonDTO(it) }.orEmpty()
            }
            .doOnSuccess {
                pokemonDao.insert(*it.map { it.toDB() }.toTypedArray())
                    .subscribe({}, {
                        it.printStackTrace()
                    })
            }
            .doOnError {
                it.printStackTrace()
            }
    }

    fun loadData(): Flowable<List<PokemonDTO>> {
        val dbObservable = getDbPokemons()
        val apiObservable = getApiPokemon()

        if (!isNetworkInProgress()) {
            dataProviderDisposable =
                Observable.concat(dbObservable.toObservable(), apiObservable.toObservable())
                    .subscribe({}, {
                        it.printStackTrace()
                    })
        }

        return pokemonDao.getAllPokemonsFlowable()
            .subscribeOn(Schedulers.io())
            .map {
                it.map { PokemonDTO(it) }
            }
    }

    fun filterPokemons(favourited: Boolean): Flowable<List<PokemonDTO>> {
        return pokemonDao.getAllPokemonsFlowable()
            .subscribeOn(Schedulers.io())
            .map {
                it.map { PokemonDTO(it) }
            }
            .map {
                if (favourited) it.filter { it.favourited } else it
            }
    }

    fun favouritePokemons(pokemon: PokemonDTO, favourited: Boolean): Single<Int> {
        return pokemon.toDB().copy(favourited = favourited).run {
            pokemonDao.update(this)
        }
    }

    fun listenToPokemonUpdates(id: Int): Maybe<PokemonDTO> {
        return pokemonDao.getPokemon(id)
            .subscribeOn(Schedulers.io())
            .map {
                PokemonDTO(it)
            }
    }

    private fun isNetworkInProgress() = !(dataProviderDisposable?.isDisposed ?: true)
}