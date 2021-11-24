package com.example.cafeconleche.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "llista_comanda")
data class LlistaComanda(
    @PrimaryKey(autoGenerate = true)
    var comandaId: Long = 0L,

    @ColumnInfo(name = "plat1")
    val plat1: String,

    @ColumnInfo(name = "plat2")
    var plat2: String,

    @ColumnInfo(name = "postre")
    var postre: String,
)