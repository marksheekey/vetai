package vet.ai.joiitechnical.modules.database.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonDB(
    @PrimaryKey val id: Int,
    val name: String,
    val url: String,
    val favourited: Boolean
)