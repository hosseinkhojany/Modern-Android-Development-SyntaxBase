package com.example.modern_android_development.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.ui.tooling.preview.Preview
import com.example.modern_android_development.login.ui.ModernAndroidDevelopmentTheme

abstract class LoginActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(context = requireContext()).apply {
            setContent {
                ModernAndroidDevelopmentTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        LoginForm{

                        }
                    }
                }
            }
        }
    }


    @Composable
    fun LoginForm(onSubmit: () -> Unit) {

        Card(shape = RoundedCornerShape(8.dp) ,
            backgroundColor = MaterialTheme.colors.surface ) {
            Box(modifier = Modifier.height(200.dp).padding(20.dp).fillMaxWidth(),
               alignment = Alignment.Center){

                TextField(value = "user name", onValueChange = {})

            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ModernAndroidDevelopmentTheme {
            LoginForm({})
        }
    }
}