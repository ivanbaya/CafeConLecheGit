package com.example.cafeconleche.logIn

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.usersDatabase.UserDatabaseDAO

class UsuarisViewModelFactory(
    private val dataSource: UserDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsuarisViewModel::class.java)) {
            return UsuarisViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}