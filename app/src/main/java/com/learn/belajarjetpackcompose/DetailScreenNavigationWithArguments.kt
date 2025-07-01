package com.learn.belajarjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@Composable
fun DetailScreenNavArguments(myName: String?, myAge: Int?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Detail Screen", fontSize = 64.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Name $myName", fontSize = 44.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Age $myAge", fontSize = 44.sp)
    }
}