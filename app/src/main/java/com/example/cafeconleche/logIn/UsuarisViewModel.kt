package com.example.cafeconleche.logIn

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeconleche.database.user.UserDatabaseDAO
import com.example.cafeconleche.database.user.Usuaris
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