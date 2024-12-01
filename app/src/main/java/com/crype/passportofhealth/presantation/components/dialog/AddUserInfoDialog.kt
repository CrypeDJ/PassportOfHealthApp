package com.crype.passportofhealth.presantation.components.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.presantation.ui.theme.Green

@Composable
fun AddUserInfoDialog(
    userModel: UserModel,
    setShowDialog: (Boolean) -> Unit,
    setValue: (UserModel) -> Unit
) {
    var name by remember { mutableStateOf(userModel.name) }
    var surname by remember { mutableStateOf(userModel.surname) }
    var lastname by remember { mutableStateOf(userModel.lastname) }
    var address by remember { mutableStateOf(userModel.address) }
    var workPlace by remember { mutableStateOf(userModel.workPlace) }
    var phoneNumber by remember { mutableStateOf(userModel.phoneNumber) }
    var mail by remember { mutableStateOf(userModel.email) }
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Введите данные",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = surname,
                        onValueChange = {
                           surname = it.take(20)
                        },
                        placeholder = {
                            Text(text = "Фамилия")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value =name,
                        onValueChange = {
                            name = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Имя")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = lastname,
                        onValueChange = {
                            lastname = it.take(15)
                        },
                        placeholder = {
                            Text(text = "Отчество")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = address,
                        onValueChange = {
                            address = it
                        },
                        placeholder = {
                            Text(text = "Адрес")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = workPlace,
                        onValueChange = {
                            workPlace = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Место работы")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Номер телефона")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = mail,
                        onValueChange = {
                            mail = it.take(30)
                        },
                        placeholder = {
                            Text(text = "Почта")
                        },
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                setValue(UserModel(surname,name,lastname,address,workPlace,phoneNumber,mail))
                                setShowDialog(false)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors().copy(
                                containerColor = Green,
                            )
                        ) {
                            Text(text = "Сохранить")
                        }
                    }
                }
            }
        }
    }
}