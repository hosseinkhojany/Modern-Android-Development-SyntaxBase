package com.example.modern_android_development

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme

//Container Single Activity
class NavHostActivityWithCompose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernAndroidDevelopmentTheme{

//                val navController = rememberNavController()
//
//                NavHost(navController = navController, startDestination = "Frag1"){
//
//                }

            }
        }
    }
}

