package com.example.cafeconleche.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ComandaDatabaseDAO {

    @Insert
    suspend fun insert(llista: LlistaComanda)

    @Update
    suspend fun update(llista: LlistaComanda)

    @Query("SELECT * from llista_comanda WHERE comandaId = :key")
    suspend fun get(key: Long): LlistaComanda?

    @Query("DELETE FROM llista_comanda")
    suspend fun clear()

    @Query("SELECT * FROM llista_comanda ORDER BY comandaId DESC LIMIT 1")
    suspend fun getLlista(): LlistaComanda?

    @Query("SELECT * FROM llista_comanda ORDER BY comandaId DESC")
    fun getAllLlistes(): LiveData<List<LlistaComanda>>
}