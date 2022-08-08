package vet.ai.joiitechnical.modules.database.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vet.ai.joiitechnical.modules.database.BaseDao
import vet.ai.joiitechnical.modules.network.pokemon.Pokemon

@Dao
interface PokemonDao: BaseDao<PokemonDB> {

    @Query("SELECT * FROM pokemon WHERE id = :id LIMIT 1 ")
    fun getPokemon(id: Int): PokemonDB

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): Flow<List<PokemonDB>>

    @Query("SELECT * FROM pokemon WHERE favourited = '1'")
    fun getFavouritePokemon(): Flow<List<PokemonDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonDB>)
}