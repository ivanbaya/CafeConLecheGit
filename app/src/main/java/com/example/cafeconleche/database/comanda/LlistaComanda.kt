package com.example.cafeconleche.database.comanda

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

    @ColumnInfo(name = "usuari")
    var usuari: String,

    @ColumnInfo(name = "data")
    var data: String,

    @ColumnInfo(name = "preu")
    var preu: Double,
)