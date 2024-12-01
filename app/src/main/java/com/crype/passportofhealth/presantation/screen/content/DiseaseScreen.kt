package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
import com.crype.passportofhealth.presantation.viewModel.DiseaseViewModel
import org.koin.androidx.compose.get

@Composable
fun DiseaseScreen(
    modifier: Modifier,
    viewModel: DiseaseViewModel = get()
){
    val diseases = viewModel.diseases
    val showAddDialog = viewModel.showAddDialog.value
    val showEditDialog = viewModel.showEditDialog.value
    val selectedItem = viewModel.selectedItem.value
    if(showAddDialog)
        AddDiseaseDialog(
            diseaseModel = DiseaseModel("", "", "", "", "", "", ""),
            setShowDialog = { viewModel.showAddDialog(it) },
            setValue = { viewModel.addDisease(it) }
        )

    if(showEditDialog && selectedItem != -1)
        AddDiseaseDialog(
            diseaseModel = diseases[selectedItem],
            setShowDialog = { viewModel.showEditDialog(it) },
            setValue = { viewModel.updateDisease(selectedItem, it) }
        )
    Column(
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        TitleComponent(
            text = "Хронические заболевания и аллергии",
            size = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        AddButtonComponent {
            viewModel.showAddDialog(true)
        }
        Spacer(modifier = Modifier.height(25.dp))
        ListDiseaseComponent(
            padding = PaddingValues(),
            list = diseases,
            onClick = {
                viewModel.showEditDialog(true, it)
            },
            onLongClick = {
                viewModel.deleteDisease(it)
            }
        )
    }
}

