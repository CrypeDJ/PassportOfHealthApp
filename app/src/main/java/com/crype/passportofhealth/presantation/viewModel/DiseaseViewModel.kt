package com.crype.passportofhealth.presantation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.model.DiseaseModel
import com.crype.passportofhealth.domain.repository.DiseaseRepository
import kotlinx.coroutines.launch

class DiseaseViewModel(
    private val repository: DiseaseRepository
) : ViewModel() {

    private val _diseases = mutableStateListOf<DiseaseModel>()
    val diseases: List<DiseaseModel> get() = _diseases

    private val _showAddDialog = mutableStateOf(false)
    val showAddDialog: State<Boolean> get() = _showAddDialog

    private val _showEditDialog = mutableStateOf(false)
    val showEditDialog: State<Boolean> get() = _showEditDialog

    private val _selectedItem = mutableStateOf(-1)
    val selectedItem: State<Int> get() = _selectedItem

    init {
        loadDiseases()
    }

    private fun loadDiseases() {
        viewModelScope.launch {
            _diseases.clear()
            _diseases.addAll(repository.getDiseases())
        }
    }

    fun addDisease(disease: DiseaseModel) {
        viewModelScope.launch {
            repository.addDisease(disease)
            _diseases.add(disease)
        }
    }

    fun updateDisease(index: Int, disease: DiseaseModel) {
        viewModelScope.launch {
            repository.updateDisease(index, disease)
            _diseases[index] = disease
        }
    }

    fun deleteDisease(index: Int) {
        viewModelScope.launch {
            repository.deleteDisease(index)
            _diseases.removeAt(index)
        }
    }

    fun showAddDialog(show: Boolean) {
        _showAddDialog.value = show
    }

    fun showEditDialog(show: Boolean, index: Int = -1) {
        _selectedItem.value = index
        _showEditDialog.value = show
    }
}