package com.example.cafeconleche

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.database.LlistaComanda
import kotlinx.coroutines.launch

class LlistaPlatsViewModel(
    val database: ComandaDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    fun novaLlista(llista : LlistaComanda) {
        viewModelScope.launch {
            insert(llista)
        }
    }
    suspend fun insert(llista : LlistaComanda) {
        database.insert(llista)
    }
}