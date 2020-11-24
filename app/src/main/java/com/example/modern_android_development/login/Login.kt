package com.example.modern_android_development.login

import androidx.annotation.FloatRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.modern_android_development.custom_views.AppBarConfig
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme
import com.example.modern_android_development.R

@Composable
fun LoginContent(onSubmit: () -> Unit){

    ModernAndroidDevelopmentTheme {
        Surface{
            Column(modifier = Modifier.fillMaxSize()) {

                AppBarConfig(title = {} , actions = {})

                Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
//                    Image(imageResource(id = R.drawable.ic_baseline_adb_24))



                    Card(elevation = 4.dp ,
                         modifier = Modifier.fillMaxWidth().height(300.dp).padding(10.dp)) {

                        Column(modifier = Modifier.fillMaxSize()) {

                            TextField(value = "Enter Name", onValueChange = {} ,
                            modifier = Modifier.fillMaxWidth())

                            TextField(value = "Enter Password", onValueChange = {} ,
                                    modifier = Modifier.fillMaxWidth())

                            Button(onClick = onSubmit ,
                                    Modifier.fillMaxWidth(0.5f) ) {
                                Text(text = "Submit")
                            }
                        }

                    }


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    LoginContent(onSubmit = {})
}

