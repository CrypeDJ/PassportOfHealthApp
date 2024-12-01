package com.crype.passportofhealth.presantation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.passportofhealth.domain.model.UserModel
import com.crype.passportofhealth.domain.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository
):ViewModel() {
    private val _user = mutableStateOf(UserModel())
    val user: State<UserModel> get() = _user

    private val _isDialogVisible = mutableStateOf(false)
    val isDialogVisible: State<Boolean> get() = _isDialogVisible

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            _user.value = userRepository.getUser()
        }
    }

    fun toggleDialogVisibility() {
        _isDialogVisible.value = !_isDialogVisible.value
    }

    fun updateUser(updatedUser: UserModel) {
        _user.value = updatedUser
    }

    fun saveUser() {
        viewModelScope.launch {
            userRepository.saveUser(_user.value)
            toggleDialogVisibility()
        }
    }
}