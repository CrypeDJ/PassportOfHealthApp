package com.crype.passportofhealth.domain.repository

import com.crype.passportofhealth.domain.model.HealthIndicatorsModel

interface HealthIndicatorRepository {
    suspend fun saveHealthIndicators(data: HealthIndicatorsModel):Result<Unit>
    suspend fun getHealthIndicators(): HealthIndicatorsModel
}