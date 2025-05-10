package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                Boxes()
            }
        }
    }
}

@Composable
fun Boxes() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(modifier = Modifier
            .background(Color.Green),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color.Red))
            Text(text = "Hello World!",
                fontSize = 60.sp
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxesPreview() {
    BelajarJetpackComposeTheme {
        Boxes()
    }
}