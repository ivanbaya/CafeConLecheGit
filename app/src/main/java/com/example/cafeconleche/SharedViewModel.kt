package com.example.cafeconleche

import android.app.Application
import androidx.lifecycle.*
import com.example.cafeconleche.database.ComandaDatabaseDAO
import com.example.cafeconleche.database.LlistaComanda
import kotlinx.coroutines.launch

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val _plat1 = MutableLiveData<String>()
    val plat1: LiveData<String>
        get() = _plat1
    private val _plat2 = MutableLiveData<String>()
    val plat2: LiveData<String>
        get() = _plat2
    private val _postre = MutableLiveData<String>()
    val postre: LiveData<String>
        get() = _postre

    fun sendPlat1(text: String) {
        _plat1.value = text
    }
    fun sendPlat2(text: String) {
        _plat2.value = text
    }
    fun sendPostre(text: String) {
        _postre.value = text
    }
}