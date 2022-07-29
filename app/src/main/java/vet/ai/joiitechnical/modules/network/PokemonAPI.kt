package vet.ai.joiitechnical.modules.network

import io.reactivex.Single
import vet.ai.joiitechnical.modules.network.pokemon.PokemonList
import retrofit2.Response
import retrofit2.http.GET

interface PokemonAPI {

    @GET("pokemon")
    fun getPokemonList(): Single<Response<PokemonList>>
}