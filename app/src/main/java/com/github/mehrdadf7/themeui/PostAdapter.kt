package com.github.mehrdadf7.themeui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_post_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addValue(str: String) {
        this.list.add(str)
        notifyItemInserted(this.list.size - 1)
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tv_title: PrimaryDarkTextView = itemView.findViewById(R.id.tv_title)
        private val tv_body : AppCompatTextView = itemView.findViewById(R.id.tv_body)

        fun bind(str: String) {
            tv_title.text = (adapterPosition + 1).toString()
            tv_title.append(". ")
            tv_title.append(str)
            tv_body.text = str
        }
    }

}
