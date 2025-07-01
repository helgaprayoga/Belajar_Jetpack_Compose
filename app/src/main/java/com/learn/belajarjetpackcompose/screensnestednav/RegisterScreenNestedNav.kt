package com.learn.belajarjetpackcompose.screensnestednav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.learn.belajarjetpackcompose.navigationnestednav.NestedNavScreens

@Composable
fun RegisterScreenNested(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register Screen")
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = {
                navController.navigate(NestedNavScreens.ScreenLoginRoute.route)
            }
        ) {
            Text(text = "Register (Go Login)")
        }
    }
}