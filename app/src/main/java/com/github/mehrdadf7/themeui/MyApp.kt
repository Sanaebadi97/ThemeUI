package com.github.mehrdadf7.themeui

import android.app.Application
import android.content.Context

import androidx.appcompat.app.AppCompatDelegate

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (Prefs.theme == Prefs.THEME_DARK)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

    companion object {
        @get:Synchronized var instance: MyApp? = null
            private set
    }
}
