package vet.ai.joiitechnical.modules.usecases
import vet.ai.joiitechnical.modules.repos.PokemonRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GerNextPageOfPokemon @Inject constructor(
    private val repo : PokemonRepo
) {
    suspend fun execute() {
        val pokemonFromApi = repo.getNextPageOfPokemon()
        repo.writePokemonToDb(pokemonFromApi)
    }

}