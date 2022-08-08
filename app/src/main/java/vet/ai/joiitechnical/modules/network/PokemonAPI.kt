package vet.ai.joiitechnical.modules.network

import vet.ai.joiitechnical.modules.network.pokemon.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI {

    @GET("pokemon")
    suspend fun getPokemonList(
    @Query("offset") offset: Int): Response<PokemonList>
}