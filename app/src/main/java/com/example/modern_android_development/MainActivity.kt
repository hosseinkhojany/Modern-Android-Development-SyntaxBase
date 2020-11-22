package com.example.modern_android_development

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Hello world!")
        }
    }
}

@Composable
fun ClickableText() {
    var showPopup by remember { mutableStateOf(false) }
    Column(Modifier.clickable(onClick = { showPopup = true }), children = {
        Card(
                shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp),
                backgroundColor = Color.LightGray
        ) {
            Text(
                    text = "Click to see dialog", modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                            fontSize = TextUnit.Sp(16),
                            fontFamily = FontFamily.Serif
                    )
            )
        }
    })

    val onPopupDismissed = { showPopup = false }

    if (showPopup) {
        AlertDialog(
                onDismissRequest = onPopupDismissed,
                text = {
                    Text("Congratulations! You just clicked the text successfully")
                },
                confirmButton = {
                    Button(
                            onClick = onPopupDismissed
                    ) {
                        Text(text = "Ok")
                    }
                })
    }
}
@Preview
@Composable
fun ClickableTextPreview() {
    Column {
        ClickableText()
    }
}
