package vet.ai.joiitechnical.modules.localData

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val LAST_OFFSET = "last_offset"
private const val GOT_ALL_POKEMON = "got_all_pokemon"

@Singleton
class LocalData @Inject constructor(@ApplicationContext context: Context) : LocalDataInterface {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("co.uk.happyapper.pokemon", Context.MODE_PRIVATE)

    override var lastOffset: Int
        get() = preferences.getInt(LAST_OFFSET,0)
        set(value) = preferences.edit().putInt(LAST_OFFSET, value).apply()

    override var gotAllPokemon: Boolean
        get() = preferences.getBoolean(GOT_ALL_POKEMON, false)
        set(value) = preferences.edit().putBoolean(GOT_ALL_POKEMON, value).apply()

}

interface LocalDataInterface{
    var lastOffset: Int
    var gotAllPokemon: Boolean
}