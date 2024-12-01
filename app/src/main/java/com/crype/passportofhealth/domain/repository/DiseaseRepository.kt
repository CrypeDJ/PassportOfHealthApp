package com.crype.passportofhealth.domain.repository

import com.crype.passportofhealth.domain.model.DiseaseModel

interface DiseaseRepository {
    suspend fun getDiseases(): List<DiseaseModel>
    suspend fun addDisease(disease: DiseaseModel):Result<Unit>
    suspend fun updateDisease(index: Int, disease: DiseaseModel):Result<Unit>
    suspend fun deleteDisease(index: Int):Result<Unit>
}