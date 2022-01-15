package com.example.cafeconleche.plats

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*

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

    private val _preu1 = MutableLiveData<Double>()
    val preu1: LiveData<Double>
        get() = _preu1
    private val _preu2 = MutableLiveData<Double>()
    val preu2: LiveData<Double>
        get() = _preu2
    private val _preu3 = MutableLiveData<Double>()
    val preu3: LiveData<Double>
        get() = _preu3

    fun sendPlat1(text: String) {
        _plat1.value = text
        Log.i(TAG,text)
    }
    fun sendPlat2(text: String) {
        _plat2.value = text
    }
    fun sendPostre(text: String) {
        _postre.value = text
    }
    fun sendPreu1(num: Double) {
        _preu1.value = num
    }
    fun sendPreu2(num: Double) {
        _preu2.value = num
    }
    fun sendPreu3(num: Double) {
        _preu3.value = num
    }
    fun setnullPlat1(){
        _plat1.value = null
    }
    fun setnullPlat2(){
        _plat2.value = null
    }
    fun setnullPlat3(){
        _postre.value = null
    }
}