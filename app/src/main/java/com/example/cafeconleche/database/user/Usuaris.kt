package com.example.cafeconleche.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuari")
data class Usuaris(
    @PrimaryKey
    val email: String,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "telefono")
    var telefono: String,

    @ColumnInfo(name = "password")
    var pass: String,
)