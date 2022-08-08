package vet.ai.joiitechnical.modules.repos

import android.util.Log
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDao
import vet.ai.joiitechnical.modules.localData.LocalData
import vet.ai.joiitechnical.modules.network.PokemonAPI
import vet.ai.joiitechnical.modules.network.pokemon.Pokemon
import javax.inject.Inject
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO as PokemonDTO

class PokemonRepo @Inject constructor(private val pokemonDao: PokemonDao,
                                      private val pokemonAPI: PokemonAPI,
                                      private val localData: LocalData) {

   suspend fun getNextPageOfPokemon(): List<Pokemon>{
       try {
           val results = pokemonAPI.getPokemonList(localData.lastOffset)
           if (results.isSuccessful) {
               results.body()?.let { result ->
                   if (result.next == null) {
                       localData.gotAllPokemon = true
                   }
                   localData.lastOffset = localData.lastOffset + result.pokemons.size
                   return result.pokemons
               }
           }
       }catch(e: Exception){
           Log.i("error",e.toString())
           //todo handle the error
       }
       return emptyList()
   }

    suspend fun writePokemonToDb(pokemon: List<Pokemon>){
        val pokemonDb = pokemon.map{
            PokemonDTO(it.name, it.url, false).toDB()
        }
        pokemonDao.insertAll(pokemonDb)
    }

    suspend fun getFavouritePokemon() = pokemonDao.getFavouritePokemon()

    suspend fun getAllPokemon() = pokemonDao.getAllPokemon()

    suspend fun getAPokemon(id: Int) = pokemonDao.getPokemon(id)

}