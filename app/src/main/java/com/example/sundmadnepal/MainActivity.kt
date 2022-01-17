package com.example.sundmadnepal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navControllerTop: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set always day mode
        // FIXME: Modify the night mode styling to be prettier, so we don't have to disable it here
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // Hide the action bar at the top
        supportActionBar?.hide()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigationBarBottom)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)

        //Used for top navigation bar
        /*val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navControllerTop = navHostFragment.navController
        setupActionBarWithNavController(navControllerTop)*/
    }

    //Used for top navigation bar
    /*override fun onSupportNavigateUp(): Boolean {
        return navControllerTop.navigateUp() || super.onSupportNavigateUp()
    }*/
}
