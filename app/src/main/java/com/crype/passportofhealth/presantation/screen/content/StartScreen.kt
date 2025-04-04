package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.buttons.MainButtonComponent
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.navigation.ContentScreen
import com.crype.passportofhealth.presantation.viewModel.UserViewModel
import org.koin.androidx.compose.get

@Composable
fun StartScreen(
    navController: NavController,
    modifier: Modifier,
    viewModel: UserViewModel = get()
){
    val user by viewModel.user
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        TitleComponent(text = "С возвращением, ${user.name}", size = 35.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item{
                MainButtonComponent (
                    text = "Вакцины",
                    onClick = {
                        navController.navigate(route = ContentScreen.Vaccination.route)
                    },
                    painter = painterResource(id = R.drawable.icon_vaccination)
                )
            }
            item{
                MainButtonComponent (
                    text = "Показатели здоровья",
                    onClick = {
                        navController.navigate(route = ContentScreen.HealthIndicator.route)
                    },
                    painter = painterResource(id = R.drawable.icon_health_indicator)                )
            }
            item{
                MainButtonComponent (
                    text = "Заболевания и аллергии",
                    onClick = {
                        navController.navigate(route = ContentScreen.Disease.route)
                    },
                    painter = painterResource(id = R.drawable.icon_illness)                )
            }
            item{
                MainButtonComponent (
                    text = "Образ жизни",
                    onClick = {
                        navController.navigate(route = ContentScreen.Lifecycle.route)
                    },
                    painter = painterResource(id = R.drawable.icon_lifestyle)                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPrev(){
    StartScreen(navController = rememberNavController(), Modifier)
}