package com.crype.passportofhealth.presantation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crype.passportofhealth.presantation.screen.root.LoginScreen
import com.crype.passportofhealth.presantation.screen.root.MainScreen
import com.crype.passportofhealth.presantation.screen.root.RegistrationScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = RootScreen.Main.route){
            MainScreen()
        }
        composable(route = RootScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = RootScreen.Register.route){
            RegistrationScreen(navController)
        }
    }
}