package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldFunction()
        }
    }
}


@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewFunction() {
    TextViewFunction()
    ImageViewFunction()
    ButtonFunction()
    TextFieldFunction()
}

@Composable
private fun TextViewFunction() {
    Text(
        text = "Hello Jetpack Compose",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        fontSize = 36.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ImageViewFunction() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Cyan),
        contentScale = ContentScale.Inside
    )
}

@Composable
private fun ButtonFunction() {
    Button(
        onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black,
        ),
        enabled = false
    ) {
        Text("Click Me")
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Dummy Image",
        )
    }
}

@Composable
private fun TextFieldFunction() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("12345", "TextFieldFunction: $it")
        },
        label = { Text("Enter Message") },
        placeholder = { Text("Hint") }
    )
}