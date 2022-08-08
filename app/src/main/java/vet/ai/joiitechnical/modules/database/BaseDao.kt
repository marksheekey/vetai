package vet.ai.joiitechnical.modules.database

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg entity: T)

    @Update
    fun update(vararg entity: T)

    @Delete
    fun delete(vararg entity: T)
}