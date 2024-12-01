package com.crype.passportofhealth.domain.repository

import com.crype.passportofhealth.domain.model.UserModel

interface UserRepository {
    suspend fun getUser(): UserModel
    suspend fun saveUser(user: UserModel):Result<Unit>
}