package com.example.cafeconleche

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.database.LlistaComanda
import com.example.cafeconleche.menjarDatabase.LlistaMenjars
import com.example.cafeconleche.menjarDatabase.MenjarDatabaseDAO
import kotlinx.coroutines.launch

class PlatsViewModel(
    val database: MenjarDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    val menjarsPlat1 = database.getAllMenjars("Plat1")
    val menjarsPlat2 = database.getAllMenjars("Plat2")
    val menjarsPostre = database.getAllMenjars("Postre")

    fun nouMenjar(menjar : LlistaMenjars) {
        viewModelScope.launch {
            insert(menjar)
        }
    }
    private suspend fun insert(menjar : LlistaMenjars) {
        database.insert(menjar)
    }
}