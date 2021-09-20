package com.erenkazancioglu.patikadevweek3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.erenkazancioglu.patikadevweek3.utils.gone
import com.erenkazancioglu.patikadevweek3.utils.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.navigation_host_fragment_container)
        NavigationUI.setupWithNavController(bottomnavigationview, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.avatar_Selection_Fragment -> hideNavigation()
                R.id.splash_Fragment -> hideNavigation()
                else -> showNavigation()
            }
        }
    }

    fun hideNavigation() {
        bottomnavigationview.postDelayed(
                {
                    bottomnavigationview.gone()
                }, 100
        )
    }
    fun showNavigation() {
        bottomnavigationview.postDelayed(
                {
                    bottomnavigationview.visible()
                }, 100
        )
    }
}