package vet.ai.joiitechnical.modules.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDatabase

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Provides
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(context, PokemonDatabase::class.java, "pokemon_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePokemonDao(db: PokemonDatabase) = db.pokemonDao()

}