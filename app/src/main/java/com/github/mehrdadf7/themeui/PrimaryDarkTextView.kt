package com.github.mehrdadf7.themeui

import android.content.Context
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class PrimaryDarkTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {

        if (BuildConfig.DEBUG) text = context.getString(R.string.lorem_fa)

        typeface = ResourcesCompat.getFont(context, R.font.iran_sans_light)

        if (Prefs.theme == Prefs.THEME_DARK) {
            setTextColor(ContextCompat.getColor(context, R.color.darkAccent))
        } else {
            setTextColor(BaseActivity.colorPrimaryDark)
        }

    }

}
