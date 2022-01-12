package com.example.cafeconleche.database.comanda

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ComandaDatabaseDAO {

    @Insert
    fun insert(llista: LlistaComanda)

    @Update
    fun update(llista: LlistaComanda)

    @Query("SELECT * from llista_comanda WHERE comandaId = :key")
    fun get(key: Long): LlistaComanda?

    @Query("DELETE FROM llista_comanda")
    fun clear()

    @Query("SELECT * FROM llista_comanda ORDER BY comandaId DESC LIMIT 1")
    fun getLlista(): LlistaComanda?

    @Query("SELECT * FROM llista_comanda WHERE usuari=:usuari ORDER BY comandaId DESC")
    fun getAllLlistes(usuari: String): List<LlistaComanda>
}