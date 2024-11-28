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
import com.crype.passportofhealth.domain.model.DiseaseModel
import com.crype.passportofhealth.presantation.ui.theme.Green

@Composable
fun AddDiseaseDialog(
    diseaseModel: DiseaseModel,
    setShowDialog: (Boolean) -> Unit,
    setValue: (DiseaseModel) -> Unit
) {
    var name by remember { mutableStateOf(diseaseModel.name)  }
    var date by remember { mutableStateOf(diseaseModel.date)  }
    var status by remember { mutableStateOf(diseaseModel.status)  }
    var symptoms by remember { mutableStateOf(diseaseModel.symptoms)  }
    var treatment by remember { mutableStateOf(diseaseModel.treatment)  }
    var nameOfDoctor by remember { mutableStateOf(diseaseModel.nameOfDoctor)  }
    var contactOfDoctor by remember { mutableStateOf(diseaseModel.contactOfDoctor)  }
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
                            Text(text = "Название заболевания")
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
                        value = status,
                        onValueChange = {
                            status = it.take(15)
                        },
                        placeholder = {
                            Text(text = "Статус")
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
                        value = symptoms,
                        onValueChange = {
                            symptoms = it
                        },
                        placeholder = {
                            Text(text = "Симптомы")
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
                        value = treatment,
                        onValueChange = {
                            treatment = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Лечение")
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
                        value = nameOfDoctor,
                        onValueChange = {
                            nameOfDoctor = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Лечащий доктор")
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
                        value = contactOfDoctor,
                        onValueChange = {
                            contactOfDoctor = it.take(10)
                        },
                        placeholder = {
                            Text(text = "Контакты доктора")
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
                                setValue(DiseaseModel(name,date,status,symptoms,treatment,nameOfDoctor,contactOfDoctor))
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