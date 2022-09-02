package com.vapps.pdfflashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.vapps.pdfflashcards.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomBar = binding.bottomAppbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val drawerLayout = binding.drawerLayout
        val builder = AppBarConfiguration.Builder(setOf(R.id.decksFragment, R.id.settingsFragment))
        builder.setOpenableLayout(drawerLayout)
        val appBarConfiguration = builder.build()
        bottomBar.setupWithNavController(navController, appBarConfiguration)
        val navigationView = binding.navigationView
        NavigationUI.setupWithNavController(navigationView, navController)
    }
}