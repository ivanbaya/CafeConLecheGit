package com.example.cafeconleche.prefs

import android.app.Application

class SharedApp : Application() {
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}