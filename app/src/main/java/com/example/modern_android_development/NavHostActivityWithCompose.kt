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



//                var visible by remember { mutableStateOf(true) }
//                AnimatedVisibility(
//                        visible = visible,
//                        enter = slideInHorizontally(
//                                // Offsets the content by 1/3 of its width to the left, and slide towards right
//                                initialOffsetX = { fullWidth -> -fullWidth / 3 },
//                                // Overwrites the default animation with tween for this slide animation.
//                                animSpec = tween(durationMillis = 200)
//                        ) + fadeIn(
//                                // Overwrites the default animation with tween
//                                animSpec = tween(durationMillis = 200)
//                        ),
//                        exit = slideOutHorizontally(
//                                // Overwrites the ending position of the slide-out to 200 (pixels) to the right
//                                targetOffsetX = { 200 },
//                                animSpec = spring(stiffness = Spring.StiffnessHigh)
//                        ) + fadeOut()
//                ) {
//                    // Content that needs to appear/disappear goes here:
//                    Box(Modifier.fillMaxWidth().height(200.dp)) {}
//                }

//                val navController = rememberNavController()
//
//                NavHost(navController = navController, startDestination = "Frag1"){
//
//                }

            }
        }
    }
}

