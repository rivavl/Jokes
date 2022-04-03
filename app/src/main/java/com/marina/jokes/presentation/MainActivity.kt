package com.marina.jokes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHost
import androidx.navigation.ui.NavigationUI
import com.marina.jokes.R
import com.marina.jokes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.navView

        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHost).navController
        NavigationUI.setupWithNavController(navView, navController)
    }
}