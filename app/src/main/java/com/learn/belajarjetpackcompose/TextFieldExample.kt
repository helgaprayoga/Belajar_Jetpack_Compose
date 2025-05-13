package com.learn.belajarjetpackcompose

import android.os.Bundle
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class TextFieldExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                TFExample()
            }
        }
    }
}

@Composable
fun SimpleTextField() {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun LabelTextField() {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text(text = "Ini label", color = Color.Blue)
        },
        singleLine = true
    )
}

@Composable
fun LeadingAndTrailingTextField() {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        leadingIcon = {
            Icon(Icons.Filled.Search, null, tint = Color.White)
        },
        trailingIcon = {
            Text(text = "@gmail.com", color = Color.White)
        }
    )
}

@Composable
fun ColorTextField() {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        leadingIcon = {
            Icon(Icons.Filled.Search, null, tint = Color.White)
        },
        trailingIcon = {
            Text(text = "@gmail.com", color = Color.White)
        },
        label = {
            Text(text = "Input Email")
        },
        placeholder = {
            Text(text = "example@gmail.com")
        },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.Red,
            cursorColor = Color.Red,
            focusedIndicatorColor = Color.Green,
            unfocusedIndicatorColor = Color.Yellow,
            focusedLabelColor = Color.Green,
            unfocusedLabelColor = Color.Yellow,
            focusedPlaceholderColor = Color.Magenta,
            unfocusedPlaceholderColor = Color.Blue
        )
    )
}

@Composable
fun PasswordTypeTextField() {
    var text by remember {
        mutableStateOf("")
    }

    var passwordHidden by remember {
        mutableStateOf(false)
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordHidden = !passwordHidden
                }
            ) {
                Icon(painterResource(id = R.drawable.eye_ic), null, tint = Color.Red)
            }
        },
        label = {
            Text(text = "password")
        },
        visualTransformation = if(passwordHidden) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun TFExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleTextField()
        SpaceLine()
        LabelTextField()
        SpaceLine()
        LeadingAndTrailingTextField()
        SpaceLine()
        ColorTextField()
        SpaceLine()
        PasswordTypeTextField()
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldExamplePreview() {
    TFExample()
}