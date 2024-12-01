package com.crype.passportofhealth.presantation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.model.LifestyleModel
import com.crype.passportofhealth.domain.repository.LifecycleRepository
import kotlinx.coroutines.launch

class LifecycleViewModel(
    private val repository: LifecycleRepository
):ViewModel() {
    private val _lifestyle = mutableStateOf(LifestyleModel())
    val lifestyle: State<LifestyleModel> get() = _lifestyle

    private val _isEditMode = mutableStateOf(false)
    val isEditMode: State<Boolean> get() = _isEditMode

    init {
        loadLifestyle()
    }

    private fun loadLifestyle() {
        viewModelScope.launch {
            _lifestyle.value = repository.getLifestyle()
        }
    }

    fun toggleEditMode() {
        _isEditMode.value = !_isEditMode.value
    }

    fun updateLifestyle(updated: LifestyleModel) {
        _lifestyle.value = updated
    }

    fun saveLifestyle() {
        viewModelScope.launch {
            repository.saveLifestyle(_lifestyle.value)
            toggleEditMode()
        }
    }
}