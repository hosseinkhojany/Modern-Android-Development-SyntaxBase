package com.example.modern_android_development.custom_views

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


@Composable
fun ClickableText(onClick: () -> Unit) {
    var showPopup by remember { mutableStateOf(false) }
    Column {
        Row(verticalAlignment =  Alignment.CenterVertically){
            Card(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.padding(8.dp)
                    .clickable(onClick = onClick)
            ) {
                Text(
                    text = "Go To Fragment2", modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = TextUnit.Sp(16),
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        }
    }

    val onPopupDismissed = { showPopup = false }

    if (showPopup) {
        AlertDialog(
            modifier = Modifier.background(color = Color.Transparent),
            onDismissRequest = onPopupDismissed,
            text = {
                Text("Congratulations! You just clicked the text successfully")
            },
            title = { Text(text = "Hello") },
            shape = RoundedCornerShape(20.dp),dismissButton = {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onPopupDismissed
                ) {
                    Text(text = "No")
                }
            },
            confirmButton = {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onPopupDismissed
                ) {
                    Text(text = "Ok")
                }
            }
        )
    }
}



@Preview
@Composable
fun ClickableTextPreview() {
    Column {
        ClickableText{}
    }
}