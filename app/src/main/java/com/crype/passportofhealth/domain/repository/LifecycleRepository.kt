package com.crype.passportofhealth.domain.repository

import com.crype.passportofhealth.domain.model.LifestyleModel

interface LifecycleRepository {
    suspend fun saveLifestyle(lifestyle: LifestyleModel):Result<Unit>
    suspend fun getLifestyle(): LifestyleModel
}