package com.example.sundmadnepal

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var navControllerTop: NavController

    // Firebase instance variables
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Authenticate database connection (anonymous authentication)
        /*
        auth = Firebase.auth
        if (auth.currentUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
            return
        }
        */
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
