package com.example.cafeconleche.llistaPlats

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeconleche.database.comanda.ComandaDatabaseDAO

class LlistaPlatsViewModelFactory(
    private val dataSource: ComandaDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LlistaPlatsViewModel::class.java)) {
            return LlistaPlatsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}