package com.example.modern_android_development

import android.graphics.Paint
import android.os.Bundle
import android.text.Layout
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.example.modern_android_development.login.LoginActivity

//Container Single Activity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

//            NavHost(navController, startDestination = "profile") {
//                composable("Registry") { LoginActivity() }
//                composable("friendslist") { FriendsList(...) }
//            }


//            val navController = rememberNavController()

        }
    }



    sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: VectorAsset) {
        object Frankendroid : BottomNavigationScreens("Frankendroid", R.string.frankendroid_route, Icons.Filled.Star)
        object Pumpkin : BottomNavigationScreens("Pumpkin", R.string.pumpkin_screen_route, Icons.Filled.Face)
        object Ghost : BottomNavigationScreens("Ghost", R.string.ghost_screen_route, Icons.Filled.Place)
        object ScaryBag : BottomNavigationScreens("ScaryBag", R.string.scary_bag_screen_route, Icons.Filled.ArrowBack)
    }

    sealed class ScaryAnimation(val animId: Int){
        object Frankendroid: ScaryAnimation(R.raw.frankensteindroid)
        object Pumpkin: ScaryAnimation(R.raw.jackolantern)
        object Ghost: ScaryAnimation(R.raw.ghost)
        object ScaryBag: ScaryAnimation(R.raw.bag)
    }

    @Composable
    fun MainScreen() {

        val navController = rememberNavController()

        val bottomNavigationItems = listOf(
            BottomNavigationScreens.Frankendroid,
            BottomNavigationScreens.Pumpkin,
            BottomNavigationScreens.Ghost,
            BottomNavigationScreens.ScaryBag
        )
        Scaffold(
            bottomBar = {
                SpookyAppBottomNavigation(navController, bottomNavigationItems)
            },
        ) {
            MainScreenNavigationConfigurations(navController)
        }
    }

    @Composable
    private fun MainScreenNavigationConfigurations(
        navController: NavHostController
    ) {
        NavHost(navController, startDestination = BottomNavigationScreens.Frankendroid.route) {
            composable(BottomNavigationScreens.Frankendroid.route) {
                ScaryScreen(ScaryAnimation.Frankendroid)
            }
            composable(BottomNavigationScreens.Pumpkin.route) {
                ScaryScreen(ScaryAnimation.Pumpkin)
            }
            composable(BottomNavigationScreens.Ghost.route) {
                ScaryScreen(ScaryAnimation.Ghost)
            }
            composable(BottomNavigationScreens.ScaryBag.route) {
                ScaryScreen(ScaryAnimation.ScaryBag)
            }
        }
    }

    @Composable
    fun ScaryScreen(
        scaryAnimation: ScaryAnimation
    ) {
        val context = ContextAmbient.current
        val customView = remember { LottieAnimationView(context) }
        // Adds view to Compose
        AndroidView({ customView },
            modifier = Modifier.background(Color.Black)
        ) { view ->
            // View's been inflated - add logic here if necessary
            with(view) {
                setAnimation(scaryAnimation.animId)
                playAnimation()
                repeatMode = LottieDrawable.REVERSE
            }
        }
    }

    @Composable
    private fun SpookyAppBottomNavigation(
        navController: NavHostController,
        items: List<BottomNavigationScreens>
    ) {
        BottomNavigation {
            val currentRoute = currentRoute(navController)
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon) },
                    label = { Text(stringResource(id = screen.resourceId)) },
                    selected = currentRoute == screen.route,
                    alwaysShowLabels = false, // This hides the title for the unselected items
                    onClick = {
                        // This if check gives us a "singleTop" behavior where we do not create a
                        // second instance of the composable if we are already on that destination
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route)
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun currentRoute(navController: NavHostController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    }

}

