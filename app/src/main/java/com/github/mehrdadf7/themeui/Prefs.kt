package com.github.mehrdadf7.themeui

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    private var sharedPreferences: SharedPreferences? = null

    const val SP_NAME      = "Theme-UI"
    const val THEME        = "THEME"
    const val THEME_BLUE   = 1
    const val THEME_RED    = 2
    const val THEME_GREEN  = 3
    const val THEME_ORANGE = 4
    const val THEME_PINK   = 5
    const val THEME_PURPLE = 6
    const val THEME_DARK   = 7

    var theme: Int = THEME_BLUE
        get()      = get()!!.getInt(THEME, field)
        set(theme) = get()!!.edit().putInt(THEME, theme).apply()

    private fun get(): SharedPreferences? {
        if (sharedPreferences == null) {
            sharedPreferences = MyApp.instance!!
                .getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences
    }

}