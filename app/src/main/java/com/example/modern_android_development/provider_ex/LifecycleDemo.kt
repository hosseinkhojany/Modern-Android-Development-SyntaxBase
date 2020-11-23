package com.example.modern_android_development.provider_ex


import android.util.Log
import androidx.compose.*
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*


@Composable
fun LifecycleDemo() {

    val count = remember { mutableStateOf(0) }

        Column {
            Button( onClick = {
                count.value++
            }){
                Text("Click me")
            }

            if (count.value < 3) {
                onActive { Log.d("Compose", "onactive with value: " + count.value) }
                onDispose { Log.d("Compose", "onDispose because value=" + count.value) }
                Text(text = "You have clicked the button: " + count.value.toString())
            }
        }

}