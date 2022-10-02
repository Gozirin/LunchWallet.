package com.example.lunchwallet.admin.servingstatus

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.lunchwallet.R
import kotlinx.android.synthetic.main.fragment_navigation_status.*
import kotlinx.android.synthetic.main.toolbar.*

class NavigationStatusFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_navigation_status)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, navigation_drawer_layout, toolbar, R.string.openDrawerContentDesc, R.string.closeDrawerContentDesc)
        toggle.isDrawerIndicatorEnabled = true
        navigation_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }
}


//
// class NavigationStatusFragment : AppCompatActivity() {
//
//    lateinit var binding: FragmentNavigationStatusBinding
//    lateinit var toggle: ActionBarDrawerToggle
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.apply {
//            toggle = ActionBarDrawerToggle(
//                this@NavigationStatusFragment,
//                navigationDrawerLayout,
//                R.string.openDrawerContentDesc,
//                R.string.closeDrawerContentDesc
//            )
//            navigationDrawerLayout.addDrawerListener(toggle)
//            toggle.syncState()
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//            navView.setNavigationItemSelectedListener {
//                when (it.itemId) {
//                    R.id.mealTimeTableFragment -> {
//                        Toast.makeText(this@NavigationStatusFragment, "MealTime TableFragment Clicked", Toast.LENGTH_SHORT).show()
//                    }
//                    R.id.notificationsScreenFragment -> {
//                        Toast.makeText(this@NavigationStatusFragment, "Notification ScreenFragment Clicked", Toast.LENGTH_SHORT).show()
//                    }
//                    R.id.logoutConfirmationFragment -> {
//                        Toast.makeText(this@NavigationStatusFragment, "Meal TimeTableFragment Clicked", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                true
//            }
//        }
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)) {
//            true
//        }
//        return super.onOptionsItemSelected(item)
//    }
// }
