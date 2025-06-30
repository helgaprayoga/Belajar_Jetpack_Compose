package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class ScaffoldExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                ScaffoldApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(title = {Text(text = "Top Bar")})
        },
        bottomBar = {
            BottomAppBar {
                Text(text = "Bottom Bar")
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) { contentPadding ->
        Column(
            modifier.padding(contentPadding)
        ) {
            Text(text = "Content")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldApp()
}