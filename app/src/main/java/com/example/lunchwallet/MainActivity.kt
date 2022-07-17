package com.example.lunchwallet

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.* // ktlint-disable no-wildcard-imports
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.lunchwallet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            mainActivityToolbar.visibility = View.GONE
        }
        setContentView(binding.root)
    }

    fun setToolBar() {
        binding.apply {
            mainActivityToolbar.visibility = View.VISIBLE
            toggle = ActionBarDrawerToggle(this@MainActivity, mainActivityDrawerLayout, R.string.openDrawerContentDesc, R.string.closeDrawerContentDesc)
            mainActivityDrawerLayout.addDrawerListener(toggle)

            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_item_meal_time_table -> {
                        Toast.makeText(this@MainActivity, "menu_item_meal_time_table", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_item_notification -> {
                        Toast.makeText(this@MainActivity, "menu_item_notification", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_item_logout -> {
                        Toast.makeText(this@MainActivity, "menu_item_logout", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }

            toolbarIcHambuger.setOnClickListener {
                mainActivityDrawerLayout.openDrawer(Gravity.START)
            }

            navView.getHeaderView(0).findViewById<ImageView>(R.id.menu_component_close_vector)?.setOnClickListener {
                mainActivityDrawerLayout.closeDrawer(Gravity.START)
            }
        }
    }

    fun setStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }
}
