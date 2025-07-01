package com.learn.belajarjetpackcompose.navigationnestednav

sealed class NestedNavScreens(val route: String) {
    object ScreenLoginRoute: NestedNavScreens(route = "LoginScreen")
    object ScreenForgotPassRoute: NestedNavScreens(route = "ForgotPassScreen")
    object ScreenRegisterRoute: NestedNavScreens(route = "RegisterScreen")
    object ScreenHomeRoute: NestedNavScreens(route = "HomeScreen")
    object ScreenARoute: NestedNavScreens(route = "ScreenA")
    object ScreenBRoute: NestedNavScreens(route = "ScreenA")
    object AuthRoute: NestedNavScreens(route = "Auth")
    object AppRoute: NestedNavScreens(route = "App")
}