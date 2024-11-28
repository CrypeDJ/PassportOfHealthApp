package com.crype.passportofhealth.domain.usecase

import com.crype.passportofhealth.domain.repository.AuthRepository

class LoginUserUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.loginUser(email, password)
    }
}