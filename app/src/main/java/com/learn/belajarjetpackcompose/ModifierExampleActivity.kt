package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class ModifierExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                ModifierExample()
            }
        }
    }
}

@Composable
fun ModifierExample1() {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Example 1",
            Modifier
                .padding(16.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun ModifierExample2() {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Example 2",
            Modifier
                .background(Color.Blue)
                .padding(16.dp)
        )
    }
}

@Composable
fun ModifierExample3() {
    val context = LocalContext.current

    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                Toast.makeText(context, "clickable after padding", Toast.LENGTH_SHORT).show()
            }
    ) {
        Text(
            text = "Example 3",
            Modifier
                .background(Color.Blue)
                .padding(16.dp)
        )
    }
}

@Composable
fun ModifierExample4() {
    val context = LocalContext.current

    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .clickable {
                Toast.makeText(context, "clickable before padding", Toast.LENGTH_SHORT).show()
            }
            .padding(16.dp)
    ) {
        Text(
            text = "Example 4",
            Modifier
                .background(Color.Blue)
                .padding(16.dp)
        )
    }
}

@Composable
fun ModifierExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ModifierExample1()
        SpaceLine()
        ModifierExample2()
        SpaceLine()
        ModifierExample3()
        SpaceLine()
        ModifierExample4()
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    ModifierExample()
}