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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.domain.model.DiseaseModel
import com.crype.passportofhealth.presantation.components.buttons.AddButtonComponent
import com.crype.passportofhealth.presantation.components.ListDiseaseComponent
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.dialog.AddDiseaseDialog

@Composable
fun DiseaseScreen(
    navController: NavController,
    modifier: Modifier
){
    val exampleList = remember {
        mutableStateListOf(
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
            DiseaseModel("COVID-19 Vaccine","15.02.2024","Completed","Mild fever, slight pain at the injection site","Paracetamol for fever, rest","Dr. Ivan Petrov","+7 912 345 6789"),
        )
    }
    val showAddDialog = remember { mutableStateOf(false) }
    if(showAddDialog.value)
        AddDiseaseDialog(diseaseModel = DiseaseModel(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
        ), setShowDialog = {
            showAddDialog.value = it
        }) {
            //Add Info to Firebase



            exampleList.add(it)
        }

    val showEditDialog = remember { mutableStateOf(false) }
    val selectedItem = remember {
        mutableStateOf(0)
    }
    if(showEditDialog.value)
        AddDiseaseDialog(diseaseModel = exampleList[selectedItem.value],
        setShowDialog = {
            showEditDialog.value = it
        }) {
            //Add Info to Firebase


            exampleList[selectedItem.value] = it
        }
    Column(
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        TitleComponent(
            text = "Хронические заболевания и аллергии",
            size = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        AddButtonComponent {
            showAddDialog.value = true
        }
        Spacer(modifier = Modifier.height(25.dp))
        ListDiseaseComponent(
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

@Preview(showBackground = true)
@Composable
fun DiseasePreview(){
    DiseaseScreen(navController = rememberNavController(), Modifier)
}