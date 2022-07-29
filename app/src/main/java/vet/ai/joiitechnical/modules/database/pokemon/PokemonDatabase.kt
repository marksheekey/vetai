package vet.ai.joiitechnical.modules.database.pokemon

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PokemonDB::class], exportSchema = false, version = 2)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}