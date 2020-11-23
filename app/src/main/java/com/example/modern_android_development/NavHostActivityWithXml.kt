package com.example.modern_android_development

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme

//Container Single Activity
class NavHostActivityWithXml : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernAndroidDevelopmentTheme{

                val navController = rememberNavController()


            }
        }
    }
}

