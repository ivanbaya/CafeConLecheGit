package com.example.cafeconleche.plats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.database.menjar.Menjar
import com.example.cafeconleche.database.menjar.MenjarDatabaseDAO
import kotlinx.coroutines.launch

class PlatsViewModel(
    val database: MenjarDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    val menjarsPlat1 = database.getAllMenjars("Plat1")
    val menjarsPlat2 = database.getAllMenjars("Plat2")
    val menjarsPostre = database.getAllMenjars("Postre")

    fun nouMenjar(menjar : Menjar) {
        viewModelScope.launch {
            insert(menjar)
        }
    }
    private suspend fun insert(menjar : Menjar) {
        database.insert(menjar)
    }
}