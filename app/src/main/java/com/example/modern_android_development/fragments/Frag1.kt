package com.example.modern_android_development.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.modern_android_development.R;
import com.example.modern_android_development.custom_views.ClickableText
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme


class Frag1 : Fragment() {

    //Hello World
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return ComposeView(context = requireContext()).apply {
            setContent {
                //Appbar configuration
                ModernAndroidDevelopmentTheme {
                    Surface(contentColor = Color.White) {
                        Column (modifier = Modifier.fillMaxSize()){

                            TopAppBar(title = { Text(text = "Hello") })

                            Column {
                                ClickableText {
                                    findNavController().navigate(
                                        R.id.action_frag1_to_frag2
                                    )
                                }
                                Text(text = "Fragment 1")
                            }
                        }
                    }
                }
            }
        }
    }
}
