package com.crype.passportofhealth.presantation.screen.root

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.buttons.ButtonComponent
import com.crype.passportofhealth.presantation.components.buttons.TransitionButtonComponent
import com.crype.passportofhealth.presantation.components.enterInfo.EnterTextComponent
import com.crype.passportofhealth.presantation.navigation.RootScreen
import com.crype.passportofhealth.presantation.viewModel.AuthUiState
import com.crype.passportofhealth.presantation.viewModel.AuthViewModel
import org.koin.androidx.compose.get

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: AuthViewModel = get()
) {
    var name by remember {
        mutableStateOf("")
    }
    var mail by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val uiState by viewModel.uiState.collectAsState()
    var errorMessage by remember {
        mutableStateOf("")
    }
    var isVisibleError by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
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
        Box(
            modifier = Modifier
                .defaultMinSize(minHeight = 25.dp)
                .padding(horizontal = 20.dp)
        ) {
            if (isVisibleError) {
                Text(
                    text = errorMessage,
                    fontSize = 15.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        EnterTextComponent(
            hint = "Имя",
            visualTransformation = VisualTransformation.None,
            text = name,
            textChange = {
                name = it
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        EnterTextComponent(
            hint = "Почта",
            visualTransformation = VisualTransformation.None,
            text = mail.trim(),
            textChange = {
                mail = it
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        EnterTextComponent(
            hint = "Пароль",
            visualTransformation = PasswordVisualTransformation(),
            text = password,
            textChange = { password = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonComponent(
            onClick = {
                if (name.isEmpty() || mail.isEmpty() || password.isEmpty()) {
                    isVisibleError = true
                    errorMessage = "Заполните поля"
                } else if (password.length < 6) {
                    isVisibleError = true
                    errorMessage = "Пароль должен содержать не менее 6 символов"
                } else viewModel.register(mail, password, name)
            },
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
        when (uiState) {
            is AuthUiState.Loading -> {
                CircularProgressIndicator()
            }

            is AuthUiState.Success -> {
                LaunchedEffect(Unit) {
                    Toast.makeText(context, "Регистрация успешна", Toast.LENGTH_LONG)
                        .show()
                    navController.navigate(route = RootScreen.Login.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            }

            is AuthUiState.Error -> {
                errorMessage = (uiState as AuthUiState.Error).message ?: "Error"
                isVisibleError = true
            }

            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(rememberNavController())
}