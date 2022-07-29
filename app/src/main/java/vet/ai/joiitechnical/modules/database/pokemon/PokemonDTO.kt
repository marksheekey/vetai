package vet.ai.joiitechnical.modules.database.pokemon

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vet.ai.joiitechnical.modules.network.pokemon.Pokemon

@Parcelize
data class PokemonDTO(val id: Int, val name: String, val url: String, val favourited: Boolean) :
    Parcelable {

    constructor(db: PokemonDB) : this(db.id, db.name, db.url, db.favourited)

    constructor(api: Pokemon) : this(api.id, api.name, api.url, false)

    fun toDB(): PokemonDB {
        return PokemonDB(id, name, url, favourited)
    }
}