package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.passportofhealth.domain.model.DiseaseModel
import com.crype.passportofhealth.domain.model.ListItemModel
import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.presantation.components.ListVaccinationComponent
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.buttons.AddButtonComponent
import com.crype.passportofhealth.presantation.components.dialog.AddDiseaseDialog
import com.crype.passportofhealth.presantation.components.dialog.AddVaccinationDialog

@Composable
fun VaccinationScreen(
    navController: NavController,
    modifier: Modifier
){
    val exampleList = remember {
        mutableStateListOf(
            VaccinationModel(
                type = "COVID-19",
                name = "Pfizer",
                date = "15.02.2024",
                series = "12345-67890",
                reaction = "Mild fever, slight pain at the injection site"
            ),
            VaccinationModel(
                type = "Influenza",
                name = "Vaxigrip",
                date = "01.01.2024",
                series = "98765-43210",
                reaction = "None"
            ),
            VaccinationModel(
                type = "Hepatitis B",
                name = "Engerix-B",
                date = "10.03.2023",
                series = "56789-12345",
                reaction = "Slight fatigue"
            ),
            VaccinationModel(
                type = "Tetanus",
                name = "Tetavax",
                date = "25.07.2022",
                series = "24680-13579",
                reaction = "Slight redness at injection site"
            )
        )
    }


    val showEditDialog = remember { mutableStateOf(false) }
    val selectedItem = remember {
        mutableStateOf(0)
    }
    if(showEditDialog.value)
        AddVaccinationDialog(vaccinationModel = exampleList[selectedItem.value],
            setShowDialog = {
                showEditDialog.value = it
            }) {
            //Add Info to Firebase


            exampleList[selectedItem.value] = it
        }

    val showAddDialog =  remember { mutableStateOf(false) }

    if(showAddDialog.value)
        AddVaccinationDialog(vaccinationModel = VaccinationModel(
            "",
            "",
            "",
            "",
            "",
        ), setShowDialog = {
            showAddDialog.value = it
        }) {
            //Add Info to Firebase
        }
    Column(
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        TitleComponent(
            text = "Вакцинации",
            size = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        AddButtonComponent {
            showAddDialog.value = true
        }
        Spacer(modifier = Modifier.height(25.dp))
        ListVaccinationComponent(
            padding = PaddingValues(),
            list = exampleList,
            onClick = {
                selectedItem.value = it
                showEditDialog.value = true
            },
            onLongClick = {
                exampleList.removeAt(it)
            }
        )
    }
}