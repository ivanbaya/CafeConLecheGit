package com.example.cafeconleche.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDAO {

    @Insert
    fun insert(user: Usuaris)

    @Update
    fun update(user: Usuaris)

    @Query("SELECT * from usuari WHERE email = :key")
    fun get(key: String): Usuaris?

    @Query("SELECT EXISTS(SELECT * from usuari WHERE email = :key)")
    fun comprobar(key: String): Boolean

    @Query("SELECT EXISTS(SELECT * from usuari WHERE email = :user AND password = :pass)")
    fun logIn(user: String, pass: String): Boolean

    @Query("DELETE FROM usuari")
    fun clear()

    @Query("SELECT * FROM usuari ORDER BY email DESC LIMIT 1")
    fun getLlista(): Usuaris?

    @Query("SELECT * FROM usuari ORDER BY email DESC")
    fun getAllUsuaris(): List<Usuaris>
}