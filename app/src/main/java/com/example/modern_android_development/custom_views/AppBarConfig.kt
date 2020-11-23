package com.example.modern_android_development.custom_views

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
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme
import com.example.modern_android_development.R


@Composable
fun AppBarConfig(modifier: Modifier = Modifier,
                 onNavIconPressed: () -> Unit = {},
                 title: @Composable RowScope.() -> Unit,
                 actions: @Composable RowScope.() -> Unit = {}){

    Column {
        TopAppBar(
            modifier = modifier,
            elevation = 0.dp, // No shadow needed
            contentColor = MaterialTheme.colors.onSurface,
            actions = actions,
            title = { Text(text = "title") },//{ Row { title() } }, // https://issuetracker.google.com/168793068
            navigationIcon = {
                Image(
                    asset = vectorResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .clickable(onClick = onNavIconPressed)
                        .padding(horizontal = 16.dp)
                )
            }
        )
        Divider()
    }
}

@Preview
@Composable
fun JetchatAppBarPreview() {
    ModernAndroidDevelopmentTheme() {
        AppBarConfig(title = { Text("Preview!") })
    }
}

@Preview
@Composable
fun JetchatAppBarPreviewDark() {
    ModernAndroidDevelopmentTheme(darkTheme = true) {
        AppBarConfig(title = { Text("Preview!") })
    }
}