package com.example.modern_android_development.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.modern_android_development.NavHostActivityWithXml
import com.example.modern_android_development.R;
import com.example.modern_android_development.custom_views.AppBarConfig
import com.example.modern_android_development.custom_views.ClickableText
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme


class Frag1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return ComposeView(context = requireContext()).apply {
            setContent {
                //Appbar configuration
                ModernAndroidDevelopmentTheme {
                    TopAppBar(title = { Text(text = "Fragment 1") })
                    Surface(contentColor = Color.White) {
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
