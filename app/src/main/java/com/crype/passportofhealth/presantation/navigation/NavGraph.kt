package com.crype.passportofhealth.presantation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crype.passportofhealth.presantation.screen.content.DiseaseScreen
import com.crype.passportofhealth.presantation.screen.content.HealthIndicatorScreen
import com.crype.passportofhealth.presantation.screen.content.LifecycleScreen
import com.crype.passportofhealth.presantation.screen.content.ProfileScreen
import com.crype.passportofhealth.presantation.screen.content.StartScreen
import com.crype.passportofhealth.presantation.screen.content.VaccinationScreen
import com.crype.passportofhealth.presantation.screen.root.LoginScreen
import com.crype.passportofhealth.presantation.screen.root.RegistrationScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            fadeIn(tween(0))
        },
        exitTransition = {
            fadeOut(tween(0))
        }
    ) {
        composable(route = ContentScreen.Start.route){
            StartScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = ContentScreen.Disease.route){
            DiseaseScreen(navController = navController, modifier = modifier)
        }
        composable(route = ContentScreen.HealthIndicator.route){
            HealthIndicatorScreen(navController = navController, modifier = modifier)
        }
        composable(route = ContentScreen.Lifecycle.route){
            LifecycleScreen(navController = navController, modifier = modifier)
        }
        composable(route = ContentScreen.Profile.route){
            ProfileScreen(navController = navController, modifier = modifier)
        }
        composable(route = ContentScreen.Vaccination.route){
            VaccinationScreen(navController = navController, modifier = modifier)
        }
        composable(route = RootScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = RootScreen.Register.route){
            RegistrationScreen(navController)
        }
    }
}