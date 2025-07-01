package com.learn.belajarjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ScreenCNavigation(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen C", fontSize = 64.sp)
        Spacer(modifier = Modifier.height(65.dp))
        Button(
            onClick = {
                navController.navigate("A") {
                    popUpTo("A")
                    {inclusive = true} // ketika klik tombol back maka akan langsung menutup aplikasi
                }
            }
        ) {
            Text(text = "Go to screen A", fontSize = 40.sp)
        }
    }
}