package vet.ai.joiitechnical.modules.usecases

import kotlinx.coroutines.flow.Flow
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDB
import vet.ai.joiitechnical.modules.repos.PokemonRepo
import javax.inject.Inject

class FetchPokemonFromDb @Inject constructor(
    private val repo : PokemonRepo
) {
    suspend fun execute(favouritesOnly: Boolean) : Flow<List<PokemonDB>> =
        if(favouritesOnly){
            repo.getFavouritePokemon()
        }else{
            repo.getAllPokemon()
        }
    }
