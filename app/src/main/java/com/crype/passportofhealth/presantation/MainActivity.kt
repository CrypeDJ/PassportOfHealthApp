package com.crype.passportofhealth.presantation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.presantation.navigation.RootNavGraph
import com.crype.passportofhealth.presantation.navigation.RootScreen
import com.crype.passportofhealth.presantation.screen.root.MainScreen
import com.crype.passportofhealth.presantation.ui.theme.PassportOfHealthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PassportOfHealthTheme {
                val navController = rememberNavController()
                RootNavGraph(navController = navController, startDestination = RootScreen.Login.route)
            }
        }
    }
}

