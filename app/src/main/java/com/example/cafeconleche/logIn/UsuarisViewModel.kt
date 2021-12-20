package com.example.cafeconleche.logIn

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.usersDatabase.UserDatabaseDAO
import com.example.cafeconleche.usersDatabase.Usuaris
import kotlinx.coroutines.launch

class UsuarisViewModel(
    val database: UserDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    fun nouUsuari(user : Usuaris) {
        viewModelScope.launch {
            insert(user)
        }
    }
    private suspend fun insert(user : Usuaris) {
        database.insert(user)
    }

    fun comprobarLoginUsuari(user : String, pass : String): Boolean{
        return database.logIn(user,pass)
    }

    fun comprobarUsuari(email : String): Boolean {
        return database.comprobar(email);
    }
}