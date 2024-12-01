package com.crype.passportofhealth.presantation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.model.VaccinationModel
import com.crype.passportofhealth.domain.repository.VaccinationRepository
import kotlinx.coroutines.launch

class VaccinationViewModel(
    private val vaccinationRepository: VaccinationRepository
): ViewModel() {
    private val _vaccinations = mutableStateListOf<VaccinationModel>()
    val vaccinations: List<VaccinationModel> get() = _vaccinations

    private val _selectedIndex = mutableStateOf(0)
    val selectedIndex: Int get() = _selectedIndex.value

    private val _isAddDialogVisible = mutableStateOf(false)
    val isAddDialogVisible: State<Boolean> get() = _isAddDialogVisible

    private val _isEditDialogVisible = mutableStateOf(false)
    val isEditDialogVisible: State<Boolean> get() = _isEditDialogVisible

    init {
        loadVaccinations()
    }

    private fun loadVaccinations() {
        viewModelScope.launch {
            _vaccinations.addAll(vaccinationRepository.getVaccinations())
        }
    }

    fun toggleAddDialog() {
        _isAddDialogVisible.value = !_isAddDialogVisible.value
    }

    fun toggleEditDialog(index: Int) {
        _selectedIndex.value = index
        _isEditDialogVisible.value = !_isEditDialogVisible.value
    }

    fun addVaccination(vaccination: VaccinationModel) {
        viewModelScope.launch {
            vaccinationRepository.addVaccination(vaccination)
            _vaccinations.add(vaccination)
        }
    }

    fun updateVaccination(vaccination: VaccinationModel) {
        viewModelScope.launch {
            vaccinationRepository.updateVaccination(_selectedIndex.value, vaccination)
            _vaccinations[_selectedIndex.value] = vaccination
        }
    }

    fun deleteVaccination(index: Int) {
        viewModelScope.launch {
            vaccinationRepository.deleteVaccination(index)
            _vaccinations.removeAt(index)
        }
    }
}