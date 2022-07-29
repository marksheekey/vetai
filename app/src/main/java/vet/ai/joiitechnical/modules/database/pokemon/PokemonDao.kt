package vet.ai.joiitechnical.modules.database.pokemon

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe
import vet.ai.joiitechnical.modules.database.BaseDao

@Dao
interface PokemonDao: BaseDao<PokemonDB> {

    @Query("SELECT * FROM pokemon WHERE id = :id LIMIT 1 ")
    fun getPokemon(id: Int): Maybe<PokemonDB>

    @Query("SELECT * FROM pokemon")
    fun getAllPokemonsRx(): Maybe<List<PokemonDB>>

    @Query("SELECT * FROM pokemon")
    fun getAllPokemonsFlowable(): Flowable<List<PokemonDB>>

    @Query("SELECT * FROM pokemon")
    fun getAllPokemons(): LiveData<List<PokemonDB>>
}