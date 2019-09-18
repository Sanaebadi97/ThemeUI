package com.github.mehrdadf7.themeui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView

class ThemeBottomSheet: RoundedBottomSheetDialogFragment(), ThemeAdapter.OnThemeClickListener {

    private lateinit var rv_theme     : RecyclerView
    private lateinit var themeAdapter : ThemeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_theme = view.findViewById(R.id.rv_theme)

        val themes: MutableList<Array<Any>> = mutableListOf()
        themes.add(arrayOf(R.color.blue500           , R.string.blue  , BLUE  ))
        themes.add(arrayOf(R.color.orange500         , R.string.orange, ORANGE))
        themes.add(arrayOf(R.color.red500            , R.string.red   , RED   ))
        themes.add(arrayOf(R.color.pink500           , R.string.pink  , PINK  ))
        themes.add(arrayOf(R.color.purple500         , R.string.purple, PURPLE))
        themes.add(arrayOf(R.color.green500          , R.string.green , GREEN ))
        themes.add(arrayOf(R.color.dark500 , R.string.dark  , DARK  ))

        themeAdapter = ThemeAdapter(this)
        rv_theme.adapter = themeAdapter
        themeAdapter.addThemes(themes)

    }

    override fun onThemeClick(tag: String) {
        when(tag) {
            BLUE   -> {
                if (Prefs.theme != Prefs.THEME_BLUE) {
                    Prefs.theme = Prefs.THEME_BLUE
                    refresh()
                }
            }
            ORANGE -> {
                if (Prefs.theme != Prefs.THEME_ORANGE) {
                    Prefs.theme = Prefs.THEME_ORANGE
                    refresh()
                }
            }
            RED    -> {
                if (Prefs.theme != Prefs.THEME_RED) {
                    Prefs.theme = Prefs.THEME_RED
                    refresh()
                }
            }
            PINK   -> {
                if (Prefs.theme != Prefs.THEME_PINK) {
                    Prefs.theme = Prefs.THEME_PINK
                    refresh()
                }
            }
            PURPLE -> {
                if (Prefs.theme != Prefs.THEME_PURPLE) {
                    Prefs.theme = Prefs.THEME_PURPLE
                    refresh()
                }
            }
            GREEN  -> {
                if (Prefs.theme != Prefs.THEME_GREEN) {
                    Prefs.theme = Prefs.THEME_GREEN
                    refresh()
                }
            }
            DARK   -> {
                if (Prefs.theme != Prefs.THEME_DARK) {
                    Prefs.theme = Prefs.THEME_DARK
                    refresh(isDarkMode = true)
                }
            }
        }
    }

    private fun refresh(isDarkMode: Boolean = false) {

        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
        )

        onThemeChangeListener?.onThemeChange()
        dismissAllowingStateLoss()
    }

    companion object {
        var onThemeChangeListener: OnThemeChangeListener? = null

        const val BLUE   = "blue"
        const val ORANGE = "orange"
        const val RED    = "red"
        const val PINK   = "pink"
        const val PURPLE = "purple"
        const val GREEN  = "green"
        const val DARK   = "dark"

        fun newInstance(): ThemeBottomSheet {
            val fragment = ThemeBottomSheet()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    interface OnThemeChangeListener {
        fun onThemeChange()
    }

}