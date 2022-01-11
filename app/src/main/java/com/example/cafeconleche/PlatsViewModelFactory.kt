package com.example.cafeconleche

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.menjarDatabase.MenjarDatabaseDAO

class PlatsViewModelFactory(
    private val dataSource: MenjarDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlatsViewModel::class.java)) {
            return PlatsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}