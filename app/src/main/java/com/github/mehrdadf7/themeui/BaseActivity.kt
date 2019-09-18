package com.github.mehrdadf7.themeui

import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.core.content.ContextCompat

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME = Prefs.theme
        when (THEME) {
            Prefs.THEME_BLUE   -> setTheme(R.style.AppThemeBlue)
            Prefs.THEME_RED    -> setTheme(R.style.AppThemeRed)
            Prefs.THEME_PINK   -> setTheme(R.style.AppThemePink)
            Prefs.THEME_GREEN  -> setTheme(R.style.AppThemeGreen)
            Prefs.THEME_ORANGE -> setTheme(R.style.AppThemeOrange)
            Prefs.THEME_PURPLE -> setTheme(R.style.AppThemePurple)
        }

        super.onCreate(savedInstanceState)
        getColors()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (THEME == Prefs.THEME_DARK) {
                window.statusBarColor = colorPrimary
            } else {
                window.statusBarColor = colorPrimaryDark
            }
        }
    }

    @SuppressLint("RestrictedApi", "Recycle")
    private fun getColors() {
        val typedValue = TypedValue()
        val theme = theme
        theme.resolveAttribute(R.attr.colorAccent, typedValue, true)
        colorAccent = typedValue.data
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        colorPrimary = typedValue.data
        theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)
        colorPrimaryDark = typedValue.data
    }

    companion object {

        var THEME: Int = 0

        @ColorInt
        var colorAccent: Int = 0
        @ColorInt
        var colorPrimary: Int = 0
        @ColorInt
        var colorPrimaryDark: Int = 0
    }

}
