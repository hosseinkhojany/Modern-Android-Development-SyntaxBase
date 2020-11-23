package com.example.modern_android_development.custom_views

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Composable

@Composable
fun ModalDrawerLayout(
    drawerState: DrawerState,
    onStateChange: (DrawerState) -> Unit,
    gesturesEnabled: Boolean = true,
    drawerContent: @Composable() () -> Unit,
    bodyContent: @Composable() () -> Unit
){



}