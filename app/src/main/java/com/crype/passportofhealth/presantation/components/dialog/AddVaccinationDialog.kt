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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.presantation.ui.theme.Green

@Composable
fun AddVaccinationDialog(
    vaccinationModel: VaccinationModel,
    setShowDialog: (Boolean) -> Unit,
    setValue: (VaccinationModel) -> Unit
) {
    var type by remember { mutableStateOf(vaccinationModel.type) }
    var name by remember { mutableStateOf(vaccinationModel.name) }
    var date by remember { mutableStateOf(vaccinationModel.date) }
    var series by remember { mutableStateOf(vaccinationModel.series) }
    var reaction by remember { mutableStateOf(vaccinationModel.reaction) }
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
                        value = name,
                        onValueChange = {
                            name = it.take(20)
                        },
                        placeholder = {
                            Text(text = "Название вакцины")
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
                        value = date,
                        onValueChange = {
                            date = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Дата")
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
                        value = type,
                        onValueChange = {
                            type = it.take(30)
                        },
                        placeholder = {
                            Text(text = "Тип вакцины")
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
                        value = series,
                        onValueChange = {
                            series = it.take(20)
                        },
                        placeholder = {
                            Text(text = "Серия")
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
                        value = reaction,
                        onValueChange = {
                            reaction = it
                        },
                        placeholder = {
                            Text(text = "Реакция на вакцину")
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
                                setValue(VaccinationModel(type,name,date,series,reaction))
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

@Preview
@Composable
fun AddVaccinationPreview() {
    AddVaccinationDialog(
        vaccinationModel = VaccinationModel("", "", "", "", ""),
        setShowDialog = {}) {

    }
}


