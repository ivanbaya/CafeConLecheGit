package com.example.cafeconleche.menjarDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menjar")
data class LlistaMenjars(
    @PrimaryKey(autoGenerate = true)
    var menjarId: Long = 0L,

    @ColumnInfo(name = "nom")
    val nom: String,

    @ColumnInfo(name = "descripcio")
    var descripcio: String,

    @ColumnInfo(name = "tipus")
    var tipus: String,

    @ColumnInfo(name = "preu")
    var preu: Double,
)