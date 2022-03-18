package com.github.mehrdadf7.themeui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postAdapter = PostAdapter()
        rv_posts.layoutManager = LinearLayoutManager(this)
        rv_posts.adapter = postAdapter

        for (i in 0..9) {
            postAdapter.addValue(getString(R.string.lorem_fa))
        }

        rv_posts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) fab_setting.hide()
                else fab_setting.show()
            }
        })

        fab_setting.setOnClickListener {
            ThemeBottomSheet.newInstance().show(supportFragmentManager, null)
        }

        ThemeBottomSheet.onThemeChangeListener = object : ThemeBottomSheet.OnThemeChangeListener {
            override fun onThemeChange() {
                recreate()
            }
        }

        val bt:Button=findViewById(R.id.bt_test)
        bt.setOnClickListener {
            Toast.makeText(this,"TESTING BUTTON FOR GIT PRACTICE",Toast.LENGTH_LONG).show()
        }

    }

}
