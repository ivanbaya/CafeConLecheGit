package com.example.cafeconleche

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val plat1 = MutableLiveData<String>()
    val plat2 = MutableLiveData<String>()
    val postre = MutableLiveData<String>()

    fun sendPlat1(text: String) {
        plat1.value = text
    }
    fun sendPlat2(text: String) {
        plat2.value = text
    }
    fun sendPostre(text: String) {
        postre.value = text
    }
}