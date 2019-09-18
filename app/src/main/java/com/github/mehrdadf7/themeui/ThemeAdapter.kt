package com.github.mehrdadf7.themeui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ThemeAdapter(
    private var onThemeClickListener: OnThemeClickListener?
) : RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder>() {

    private val list: MutableList<Array<Any>> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        return ThemeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_theme_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addThemes(list: MutableList<Array<Any>>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ThemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon    : AppCompatImageView = itemView.findViewById(R.id.theme_iv_icon)
        private val name    : AppCompatTextView  = itemView.findViewById(R.id.theme_tv_name)

        fun bind(theme: Array<Any>) {

            val color = ContextCompat.getColor(itemView.context, theme[0] as Int)

            icon.setColorFilter(color)

            name.setText(theme[1] as Int)
            name.setTextColor(color)

            itemView.setOnClickListener {
                onThemeClickListener?.onThemeClick(theme[2] as String)
            }

        }
    }

    interface OnThemeClickListener {
        fun onThemeClick(tag: String)
    }
}
