package com.learn.belajarjetpackcompose

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class ButtonExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                ButtonExample()
            }
        }
    }
}

@Composable
fun ButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        JustButton()
        SpaceLine()
        ColorButton()
        SpaceLine()
        IconTextButton()
        SpaceLine()
        ButtonBorder()
        SpaceLine()
        ButtonShape()
    }
}

@Composable
fun JustButton() {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, "Click Just Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(text = "Just Button")
    }
}

@Composable
fun ColorButton() {
    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.Red),
            onClick = {
                Toast.makeText(context, "Click Red Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Red Button", color = Color.White)
        }

        Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color.Blue),
            onClick = {
                Toast.makeText(context, "Click Blue Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Blue Button", color = Color.White)
        }

        Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color.Green),
            onClick = {
                Toast.makeText(context, "Click Green Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Green Button", color = Color.White)
        }
    }
}

@Composable
fun IconTextButton() {
    val context = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(Color.Red),
        onClick = {
            Toast.makeText(context, "Click Icon Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(
            Icons.Filled.Email,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = Color.White
        )

        Spacer(Modifier.size(ButtonDefaults.IconSize))

        Text(text = "Icon Button")
    }
}

@Composable
fun ButtonBorder() {
    Button(
        colors = ButtonDefaults.buttonColors(Color.Blue),
        border = BorderStroke(2.dp, Color.Green),
        onClick = {}
    ) {
        Text(text = "Button Border")
    }
}

@Composable
fun ButtonShape() {
    Button(
        colors = ButtonDefaults.buttonColors(Color.Green),
        onClick = {},
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "Button Shape")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    ButtonExample()
}
