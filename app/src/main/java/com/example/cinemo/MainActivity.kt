package com.example.cinemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cinemo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        navController.setGraph(R.navigation.mobile_navigation)

        val navView: BottomNavigationView = binding.bottomNav
        navView.setupWithNavController(navController)

    }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        when (p0.itemId) {
//            R.id.aboutActivity -> {
//                val uri = Uri.parse("cinemo://about")
//                startActivity(Intent(Intent.ACTION_VIEW, uri))
//            }
//        }
//        return false
//    }

}