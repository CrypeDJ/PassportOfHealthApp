package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.presantation.components.ListVaccinationComponent
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.buttons.AddButtonComponent
import com.crype.passportofhealth.presantation.components.dialog.AddVaccinationDialog
import com.crype.passportofhealth.presantation.viewModel.VaccinationViewModel
import org.koin.androidx.compose.get

@Composable
fun VaccinationScreen(
    modifier: Modifier,
    viewModel: VaccinationViewModel = get()
) {

    val vaccinations = viewModel.vaccinations
    val isAddDialogVisible by viewModel.isAddDialogVisible
    val isEditDialogVisible by viewModel.isEditDialogVisible
    val selectedIndex = viewModel.selectedIndex
    if (isAddDialogVisible)
        AddVaccinationDialog(
            vaccinationModel = VaccinationModel(),
            setShowDialog = { viewModel.toggleAddDialog() }) {
            viewModel.addVaccination(it)
        }
    if (isEditDialogVisible)
        AddVaccinationDialog(
            vaccinationModel = vaccinations[selectedIndex],
            setShowDialog = { viewModel.toggleEditDialog(selectedIndex) }) {
            viewModel.updateVaccination(it)
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
            viewModel.toggleAddDialog()
        }
        Spacer(modifier = Modifier.height(25.dp))
        ListVaccinationComponent(
            padding = PaddingValues(),
            list = vaccinations,
            onClick = {
                viewModel.toggleEditDialog(it)
            },
            onLongClick = {
                viewModel.deleteVaccination(it)
            }
        )
    }
}