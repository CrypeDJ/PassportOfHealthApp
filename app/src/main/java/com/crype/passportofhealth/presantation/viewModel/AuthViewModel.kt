package com.crype.passportofhealth.presantation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.usecase.LoginUserUseCase
import com.crype.passportofhealth.domain.usecase.RegisterUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> get() = _uiState

    fun register(email: String, password: String, name: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            val result = registerUserUseCase(email, password, name)
            _uiState.value =
                if (result.isSuccess) AuthUiState.Success else AuthUiState.Error(result.exceptionOrNull()?.message)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            val result = loginUserUseCase(email, password)
            _uiState.value =
                if (result.isSuccess) AuthUiState.Success else AuthUiState.Error(result.exceptionOrNull()?.message)
        }
    }
}

sealed class AuthUiState {
    object Idle : AuthUiState()
    object Loading : AuthUiState()
    object Success : AuthUiState()
    data class Error(val message: String?) : AuthUiState()
}