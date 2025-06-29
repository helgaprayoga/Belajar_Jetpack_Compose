package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class BottomNavigationMenuExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedItem by remember {
                mutableStateOf(0)
            }

            BottomNavigationExample(selectedItem, onSelectedItem = {
                selectedItem = it
            })
        }
    }
}

@Composable
fun BottomNavigationExample(selectedItem: Int, onSelectedItem: (index: Int) -> Unit) {
    val items = listOf("Menu 1", "Menu 2", "Menu 3", "Menu 4")
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text("Halaman Utama")
        }

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationBar(
                modifier = Modifier.padding(bottom = 20.dp, start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(50)),
                tonalElevation = 10.dp,
                containerColor = Color.DarkGray
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            when (index) {
                                0 -> {
                                    Icon(Icons.Filled.Home, contentDescription = "Home")
                                }
                                1 -> {
                                    Icon(Icons.Filled.Email, contentDescription = "Email")
                                }
                                2 -> {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                                }
                                3 -> {
                                    Icon(Icons.Filled.AccountCircle, contentDescription = "Account")
                                }
                            }
                        },
                        label = {
                            Text(item)
                        },
                        selected = selectedItem == index,
                        onClick = {
                            if (index == 1) {
                                Toast.makeText(context, "Bottom Navigation Bar", Toast.LENGTH_SHORT).show()
                            }
                            onSelectedItem(index)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Cyan,
                            unselectedIconColor = Color.Gray
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    BelajarJetpackComposeTheme {
        var selectedItem by remember {
            mutableStateOf(0)
        }

        BottomNavigationExample(selectedItem, onSelectedItem = {
            selectedItem = it
        })
    }
}