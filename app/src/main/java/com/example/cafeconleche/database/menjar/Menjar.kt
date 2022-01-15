package com.example.cafeconleche.database.menjar

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menjar")
data class Menjar(
    @PrimaryKey(autoGenerate = true)
    var menjarId: Long = 0L,

    @ColumnInfo(name = "nom")
    var nom: String = "",

    @ColumnInfo(name = "descripcio")
    var descripcio: String = "",

    @ColumnInfo(name = "tipus")
    var tipus: String = "",

    @ColumnInfo(name = "preu")
    var preu: Double = 0.0,
) {
    fun populateData(): Array<Menjar>? {
        return arrayOf<Menjar>(
            Menjar(0, "Sopa de pasta", "Amb brou de pollastre y fideus", "Plat1", 4.00),
            Menjar(1, "Espaguetis a la bolonyesa", "Espaguetis, sofregit de tomàquet i carn", "Plat1", 6.00),
            Menjar(2, "Amanida verda", "Enciam, tomàquet, ceba, tonyina i olives", "Plat1", 5.50),
            Menjar(3, "Llenties", "Amb xoriç", "Plat1", 6.10),
            Menjar(4, "Tomàquet farcida", "De carn i gratinades", "Plat2", 5.20),
            Menjar(5, "Pollastre al forn", "Amb patates rostides", "Plat2", 7.50),
            Menjar(6, "Llenguado", "Al forn amb veduretes", "Plat2", 7.30),
            Menjar(7, "Bistec a la planxa", "Amb arròs blanc", "Plat2", 6.90),
            Menjar(8, "Flam d'ou", "Cassolà amb caramel", "Postre", 4.20),
            Menjar(9, "Crema catalana", "Amb sucre cremat", "Postre", 4.30),
            Menjar(10,"Gelat", "De vainilla i xocolata", "Postre", 3.90),
        )
    }
}