package com.example.lunchwallet

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.* // ktlint-disable no-wildcard-imports
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

    private fun closeDrawer() {
        binding.apply {
            mainActivityDrawerLayout.closeDrawer(Gravity.START)
        }
    }

    private fun openDrawer() {
        binding.apply {
            mainActivityDrawerLayout.openDrawer(Gravity.START)
        }
    }

    private fun inflateLogoutView() {
        closeDrawer()
        val view = View.inflate(this@MainActivity, R.layout.logout_confirmation, null)
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(view)

        val dialog = builder.create()

        dialog.apply {
            show()
            window?.attributes?.apply {
                gravity = Gravity.TOP
            }
            window?.setBackgroundDrawableResource(android.R.color.transparent)

            val dismissBtn = findViewById<Button>(R.id.dismiss_logout_btn)
            val logoutBtn = findViewById<Button>(R.id.logout_btn)

            logoutBtn?.apply {
                setOnClickListener {
                    dismiss()
                    Toast.makeText(this@MainActivity, "Logged out!", Toast.LENGTH_SHORT).show()
                }
            }

            dismissBtn?.apply {
                setOnClickListener {
                    dismiss()
                    Toast.makeText(this@MainActivity, "Dismissed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
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
                        inflateLogoutView()
                        Toast.makeText(this@MainActivity, "menu_item_logout", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }

            toolbarIcHambuger.setOnClickListener {
                openDrawer()
            }

            navView.getHeaderView(0).findViewById<ImageView>(R.id.menu_component_close_vector)?.setOnClickListener {
                closeDrawer()
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
