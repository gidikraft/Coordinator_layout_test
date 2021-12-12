package com.example.coordinatorlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private val appBarLayout: AppBarLayout by lazy {
        findViewById(R.id.app_bar_layout)
    }

    private val toolbar: Toolbar by lazy {
        findViewById(R.id.toolbar)
    }

    private val viewCover: View by lazy {
        findViewById(R.id.view_cover)
    }

    private val floatingActionButton: FloatingActionButton by lazy {
        findViewById(R.id.floating_action_button)
    }

    private val collapsingToolbarLayout: CollapsingToolbarLayout by lazy {
        findViewById(R.id.collapsing_toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appBarOffsetChangedListener()
        clickFloatingActionButton()

        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsingToolbar) //text not changing

        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.pokeball)
        toolbar.title = "title"
        toolbar.inflateMenu(R.menu.coordinantor_layout_menu)
        menuClickListener()
    }

    private fun appBarOffsetChangedListener(){
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{
                appBarLayout, verticalOffset ->

            val offset = abs(verticalOffset)
            val scrollRange = appBarLayout.totalScrollRange

            val alpha = offset.toFloat() / scrollRange.toFloat()
            viewCover.alpha = alpha
        })
    }

    private fun clickFloatingActionButton(){
        floatingActionButton.setOnClickListener {
            Toast.makeText(this, "Floating action button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun menuClickListener(){
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu_one -> {
                    Toast.makeText(this@MainActivity, "menu one clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_two -> {
                    Toast.makeText(this@MainActivity, "menu two clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_three -> {
                    Toast.makeText(this@MainActivity, "menu three clicked", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}