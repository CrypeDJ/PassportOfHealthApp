package com.crype.passportofhealth.presantation.screen.root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.buttons.ButtonComponent
import com.crype.passportofhealth.presantation.components.enterInfo.EnterTextComponent
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.buttons.TransitionButtonComponent
import com.crype.passportofhealth.presantation.navigation.RootScreen

@Composable
fun RegistrationScreen(
    navController: NavController
){

    Column(
        modifier = Modifier.padding(25.dp)
    ) {
        Spacer(modifier = Modifier.padding(60.dp))
        Icon(
            painter = painterResource(id = R.drawable.main_icon),
            contentDescription = "",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        TitleComponent(
            text = "Регистрация",
            size = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        EnterTextComponent(
            hint = "Почта",
            visualTransformation = VisualTransformation.None,
            text = "",
            textChange = {

            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        EnterTextComponent(
            hint = "Пароль",
            visualTransformation = PasswordVisualTransformation(),
            text = "",
            textChange = {  }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonComponent(
            onClick = { /*TODO*/ },
            text = "Регистрация"
        )
        Spacer(modifier = Modifier.height(10.dp))
        TransitionButtonComponent(
            onClick = {
                navController.navigate(RootScreen.Login.route)
            },
            text = "Уже есть аккаунт?",
            buttonText = "Войти",
            size = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview(){
    RegistrationScreen(rememberNavController())
}