package com.learn.belajarjetpackcompose.bottombarnestednav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Shop: BottomBarScreen(
        route = "Shop",
        title = "Order",
        icon = Icons.Default.ShoppingCart
    )
    object Profile: BottomBarScreen(
        route = "Profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}