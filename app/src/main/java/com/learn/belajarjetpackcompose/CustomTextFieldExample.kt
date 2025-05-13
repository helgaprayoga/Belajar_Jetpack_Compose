package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.belajarjetpackcompose.ui.theme.AppShapes
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class CustomTextFieldExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                CustomTextFieldColumn()
            }
        }
    }
}

@Composable
fun CustomTextField() {
    var text by remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(10.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .background(color = Color.White, shape = CircleShape)
                .height(45.dp)
                .fillMaxWidth(),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    IconButton(onClick = {}) { 
                        Icon(Icons.Filled.Face, null)
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        innerTextField()
                    }

                    IconButton(onClick = {
                        keyboardController?.hide()
                    }) {
                        Icon(Icons.Filled.Send, null)
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
    }
}

@Composable
fun OutlineTextField() {
    var text by remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        label = {
            Text(text = "Email", color = Color.Red)
        }, leadingIcon = {
            Icon(Icons.Filled.Email, null, tint = Color.Red)
        }, trailingIcon = {
            Row(
                modifier = Modifier
                    .padding(end = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "@gmail.com", color = Color.Red)
                IconButton(onClick = {
                    keyboardController?.hide()
                }) {
                    Icon(Icons.Filled.Send, null, tint = Color.Red)
                }
            }
        }, placeholder = {
            Text(text = "example", color = Color.Red)
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        maxLines = 1,
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.White
        )

    )
}

@Composable
fun CustomTextFieldColumn() {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
    ) {
        CustomTextField()
        SpaceLine()
        OutlineTextField()
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    CustomTextFieldColumn()
}