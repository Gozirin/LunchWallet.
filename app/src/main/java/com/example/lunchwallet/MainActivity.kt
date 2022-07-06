package com.example.lunchwallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lunchwallet.databinding.ActivityMainBinding
import com.example.lunchwallet.ui.views.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.container.id, MainFragment.newInstance())
                .commit()
        }
    }
}
