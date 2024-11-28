package com.crype.passportofhealth.domain.repository

interface AuthRepository {
    suspend fun registerUser(email: String, password: String, name: String): Result<Unit>
    suspend fun loginUser(email: String, password: String): Result<Unit>
}