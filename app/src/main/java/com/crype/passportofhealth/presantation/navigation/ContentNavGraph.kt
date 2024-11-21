package com.crype.passportofhealth.presantation.navigation

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

@Composable
fun ContentNavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
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
    }
}