package com.example.cafeconleche.llistaPlats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.prefs.SharedApp
import com.example.cafeconleche.database.comanda.ComandaDatabaseDAO
import com.example.cafeconleche.database.comanda.LlistaComanda
import kotlinx.coroutines.launch

class LlistaPlatsViewModel(
    val database: ComandaDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    val comandas = database.getAllLlistes(SharedApp.prefs.name.toString())

    fun novaLlista(llista : LlistaComanda) {
        viewModelScope.launch {
            insert(llista)
        }
    }
    private suspend fun insert(llista : LlistaComanda) {
        database.insert(llista)
    }
}