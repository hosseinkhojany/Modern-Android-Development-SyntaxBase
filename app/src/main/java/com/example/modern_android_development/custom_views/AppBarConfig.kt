package com.example.modern_android_development.custom_views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.modern_android_development.NavHostActivityWithCompose
import com.example.modern_android_development.NavHostActivityWithXml
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme
import com.example.modern_android_development.R


@Composable
fun AppBarConfig(activity: Activity?,
                modifier: Modifier = Modifier,
                 onNavIconPressed: () -> Unit = {},
                 title: @Composable RowScope.() -> Unit,
                 actions: @Composable RowScope.() -> Unit = {}){

        TopAppBar(
                modifier = modifier,
                elevation = 0.dp, // No shadow needed
                contentColor = MaterialTheme.colors.onSurface,
                actions = actions,
                title = { Row { title() } },//{ Row { title() } }, // https://issuetracker.google.com/168793068
                navigationIcon = {
                    Image(
                            asset = vectorResource(id = R.drawable.ic_baseline_menu_24),
                            modifier = Modifier
                                    .clickable(onClick = {
                                        (activity as? NavHostActivityWithXml)?.openDrawer()
                                    })
                                    .padding(horizontal = 16.dp)
                    )
                }
        )
        Divider()
}

@Preview
@Composable
fun JetchatAppBarPreview() {
    ModernAndroidDevelopmentTheme() {
        AppBarConfig(activity = null , title = { Text("Preview!") })
    }
}

@Preview
@Composable
fun JetchatAppBarPreviewDark() {
    ModernAndroidDevelopmentTheme(darkTheme = true) {
        AppBarConfig(activity = null , title = { Text("Preview!") })
    }
}