package com.crype.passportofhealth.presantation.navigation

sealed class RootScreen(val route:String) {
    object Login : RootScreen("login")
    object Register : RootScreen("register")
    object Main : RootScreen("main")
}