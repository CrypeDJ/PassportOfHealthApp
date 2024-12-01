package com.crype.passportofhealth.presantation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.BottomBarComponent
import com.crype.passportofhealth.presantation.navigation.ContentScreen
import com.crype.passportofhealth.presantation.navigation.NavGraph
import com.crype.passportofhealth.presantation.navigation.RootScreen
import com.crype.passportofhealth.presantation.ui.theme.BackWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            val showBackButton = currentRoute != ContentScreen.Start.route
            if (currentRoute != RootScreen.Login.route && currentRoute != RootScreen.Register.route) {
                CenterAlignedTopAppBar(
                    title = {
                        Icon(
                            painter = painterResource(id = R.drawable.main_icon),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .height(45.dp)
                        )
                    },
                    navigationIcon = {
                        if (showBackButton) {
                            IconButton(
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "",
                                )
                            }
                        }
                    },
                    actions = {
                        if (currentRoute != ContentScreen.Profile.route) {
                            IconButton(onClick = {
                                navController.navigate(route = ContentScreen.Profile.route)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Face,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(35.dp)
                                        .width(35.dp),
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute != RootScreen.Login.route && currentRoute != RootScreen.Register.route) {
                BottomAppBar(
                    containerColor = Color.Transparent,

                    ) {
                    BottomBarComponent(
                        onVaccinationClick = {
                            navController.navigate(route = ContentScreen.Vaccination.route)
                        },
                        onLifecycleClick = {
                            navController.navigate(route = ContentScreen.Lifecycle.route)
                        },
                        onHealthIndicatorsClick = {
                            navController.navigate(route = ContentScreen.HealthIndicator.route)
                        },
                        onStartClick = {
                            navController.navigate(route = ContentScreen.Start.route)
                        },
                        onDiseaseClick = {
                            navController.navigate(route = ContentScreen.Disease.route)
                        }
                    )
                }
            }
        },
        content = { innerPadding ->
            NavGraph(
                navController = navController,
                startDestination = RootScreen.Login.route,
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 15.dp)
            )
        },
        modifier = Modifier.background(color = BackWhite)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}