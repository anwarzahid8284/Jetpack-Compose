package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //TextFieldFunction()
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewFunction() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Recomposable()
    }
    /*ProfileViewFunction()
    RowViewFunction()
    ColumnViewFunction()
    TextViewFunction()
    ImageViewFunction()
    ButtonFunction()
    TextFieldFunction()*/
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
        placeholder = { Text("Hint") }
    )
}

@Composable
private fun ColumnViewFunction() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("A", fontSize = 40.sp)
        Text("B", fontSize = 40.sp)
    }
}

@Composable
private fun RowViewFunction() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("A", fontSize = 40.sp)
        Text("B", fontSize = 40.sp)
    }
}

@Composable
private fun ProfileViewFunction() {
    Row {
        Image(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = "Profile Image",
            modifier = Modifier.size(60.dp)
        )
        Column {
            Text("King Jhon", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text("Software Developer", fontSize = 20.sp, fontWeight = FontWeight.Thin)
        }
    }
}
@Composable
private fun Recomposable(){
    val state = remember { mutableStateOf(0.0) }
    Log.d("12345", "Recomposable: function block")
    Button(onClick ={state.value = Math.random()}, modifier = Modifier.size(150.dp, 50.dp)) {
        Text(text = state.value.toString())
        Log.d("12345", "Recomposable: ")
    }
}
@Composable
fun ModifierFunction(){
    Text(
        text = "Hello Developer",
        color = Color.Black,
        modifier = Modifier
            .background(Color.Blue)
            .size(200.dp)
            .padding(36.dp)
            .border(4.dp, color = Color.White)
            .clip(CircleShape)
            .background(Color.Yellow)
    )
}