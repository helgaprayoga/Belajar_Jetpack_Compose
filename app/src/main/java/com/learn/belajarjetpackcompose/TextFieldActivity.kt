package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                TextFieldMethod()
            }
        }
    }
}

@Composable
fun TextFieldMethod() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("Ketik Dsini...") }
        TextField(value = text, onValueChange = { newText ->
            text = newText
        },
            label = {
                Text(text = "Nama")
            },
            maxLines = 1, // bisa diatur berapa banyak maksimal baris
            singleLine = true, // singleLine digunakan jika hanya akan menggunakan 1 baris
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email"
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Done"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, // di keyboard ada @ dan .
                imeAction = ImeAction.Done // keyboard pada pojok kanan bawah akan mengikuti ini
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("Ime Action", "Done")
                }
            )
        )
        OutlinedTextField(value = text, onValueChange = { newText ->
            text = newText
        },
            label = {
                Text(text = "Nama")
            },
            maxLines = 1, // bisa diatur berapa banyak maksimal baris
            singleLine = true, // singleLine digunakan jika hanya akan menggunakan 1 baris
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email"
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Done"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, // di keyboard ada @ dan .
                imeAction = ImeAction.Done // keyboard pada pojok kanan bawah akan mengikuti ini
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("Ime Action", "Done")
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    BelajarJetpackComposeTheme {
        TextFieldMethod()
    }
}