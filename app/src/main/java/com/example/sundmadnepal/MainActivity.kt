package com.example.sundmadnepal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sundmadnepal.data.DataSource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var navControllerTop: NavController

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set always day mode
        // FIXME: Modify the night mode styling to be prettier, so we don't have to disable it here
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        auth = Firebase.auth
        if (auth.currentUser == null) {
            startActivity(Intent(this, AnonymousSignInActivity::class.java))
            finish()
            return
        }

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

    public override fun onStart() {
        super.onStart()

        if (auth.currentUser == null) {
            startActivity(Intent(this, AnonymousSignInActivity::class.java))
            finish()
            return
        }
    }

    //Used for top navigation bar
    /*override fun onSupportNavigateUp(): Boolean {
        return navControllerTop.navigateUp() || super.onSupportNavigateUp()
    }*/
}
