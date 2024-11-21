package com.crype.passportofhealth.presantation.navigation

sealed class ContentScreen(val route: String) {
    object Start : ContentScreen("start")
    object Disease : ContentScreen("disease")
    object HealthIndicator : ContentScreen("health_indicator")
    object Lifecycle : ContentScreen("lifecycle")
    object Profile : ContentScreen("profile")
    object Vaccination : ContentScreen("vaccination")
}