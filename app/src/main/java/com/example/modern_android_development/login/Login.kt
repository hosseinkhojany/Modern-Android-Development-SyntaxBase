package com.example.modern_android_development.login

import android.app.Activity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.modern_android_development.custom_views.AppBarConfig
import com.example.modern_android_development.ui.ModernAndroidDevelopmentTheme

@Composable
fun LoginContent(activity: Activity?, onSubmit: () -> Unit){

    ModernAndroidDevelopmentTheme {
        Surface{
            Column(modifier = Modifier.fillMaxSize()) {

                ConstraintLayout(modifier = Modifier.fillMaxSize().padding(10.dp)) {

                    Card(elevation = 4.dp ,
                         modifier = Modifier.fillMaxWidth()
                                 .wrapContentHeight()
                                 .padding(10.dp).constrainAs(createRef()){
                                     top.linkTo(parent.top)
                                     start.linkTo(parent.end)
                                     end.linkTo(parent.start)
                                     bottom.linkTo(parent.bottom , margin = 60.dp)
                                 }) {

                        ConstraintLayout(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
                            val (button , username , password , text) = createRefs()


                            Text(text = "LoginForm" , modifier = Modifier.constrainAs(text){
                                top.linkTo(text.bottom , margin = 16.dp)
                                start.linkTo(parent.end , margin = 16.dp)
                                end.linkTo(parent.start, margin = 16.dp)
                            })


                            var state_user by savedInstanceState { "" }
                            OutlinedTextField(value = state_user, label = { Text(text = "UserName") }
                                    , onValueChange = {state_user = it} ,
                            modifier = Modifier.constrainAs(username){
                                top.linkTo(parent.top , margin = 16.dp)
                                start.linkTo(parent.end , margin = 16.dp)
                                end.linkTo(parent.start, margin = 16.dp)
                            } , trailingIcon = { Icon(Icons.Filled.Email) })


                            var state_pass by savedInstanceState { "" }
                            OutlinedTextField(value = state_pass, label = { Text(text = "Password") }
                                    , onValueChange = {state_pass = it} ,
                                    modifier = Modifier.constrainAs(password){
                                        top.linkTo(username.bottom , margin = 16.dp)
                                        start.linkTo(parent.end , margin = 16.dp)
                                        end.linkTo(parent.start, margin = 16.dp)
                                    }, trailingIcon = { Icon(Icons.Filled.Info)})


                            Button(onClick = onSubmit ,
                                    Modifier.fillMaxWidth(0.5f)
                                            .constrainAs(button){
                                                top.linkTo(password.bottom , margin = 16.dp)
                                                start.linkTo(parent.end)
                                                end.linkTo(parent.start)
                                                bottom.linkTo(parent.bottom , margin = 16.dp)
                                            }) {
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
    LoginContent(activity = null , onSubmit = {})
}


