package com.ardev.proadts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ardev.proadts.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_main

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun onBackPressed() {
        val currentFragment = getCurrentFragment()
        if (null != currentFragment && currentFragment.isOverrideOnBackPress()) {
            currentFragment.onBackPress()
        } else {
            super.onBackPressed()
        }
    }
}