package com.crype.passportofhealth.presantation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.model.HealthIndicatorsModel
import com.crype.passportofhealth.domain.repository.HealthIndicatorRepository
import kotlinx.coroutines.launch

class HealthIndicatorViewModel(
    private val repository: HealthIndicatorRepository
): ViewModel() {
    private val _healthIndicators = mutableStateOf(HealthIndicatorsModel())
    val healthIndicators: State<HealthIndicatorsModel> get() = _healthIndicators

    private val _isEditMode = mutableStateOf(false)
    val isEditMode: State<Boolean> get() = _isEditMode

    init {
        loadHealthIndicators()
    }

    private fun loadHealthIndicators() {
        viewModelScope.launch {
            _healthIndicators.value = repository.getHealthIndicators()
        }
    }

    fun toggleEditMode() {
        _isEditMode.value = !_isEditMode.value
    }

    fun updateHealthIndicator(updated: HealthIndicatorsModel) {
        _healthIndicators.value = updated
    }

    fun saveHealthIndicators() {
        viewModelScope.launch {
            repository.saveHealthIndicators(_healthIndicators.value)
            toggleEditMode()
        }
    }

    fun imtCalculate():String {
        val weight = _healthIndicators.value.weight.toFloatOrNull()
        val heightCm = _healthIndicators.value.height.toFloatOrNull()

        if (weight == null || heightCm == null || heightCm <= 0) {
            return "Некорректные данные"
        }

        val heightMeters = heightCm / 100
        val imt = weight / (heightMeters * heightMeters)

        return "%.2f".format(imt)
    }
}