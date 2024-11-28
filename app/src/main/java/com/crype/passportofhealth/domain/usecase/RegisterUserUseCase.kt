package com.crype.passportofhealth.domain.usecase

import com.crype.passportofhealth.domain.repository.AuthRepository

class RegisterUserUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String, name: String): Result<Unit> {
        return repository.registerUser(email, password, name)
    }
}