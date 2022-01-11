package com.example.cafeconleche.menjarDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenjarDatabaseDAO {

    @Insert
    fun insert(llista: Menjar)

    @Update
    fun update(llista: Menjar)

    @Query("SELECT * from menjar WHERE menjarId = :key")
    fun get(key: Long): Menjar?

    @Query("DELETE FROM menjar")
    fun clear()

    @Query("SELECT * FROM menjar ORDER BY menjarId DESC LIMIT 1")
    fun getLlista(): Menjar?

    @Query("SELECT * FROM menjar WHERE tipus = :tipus ORDER BY menjarId DESC")
    fun getAllMenjars(tipus: String): List<Menjar>

    @Insert
    fun insertAll(articles: Array<Menjar>)
}