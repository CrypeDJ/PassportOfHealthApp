package com.crype.passportofhealth.domain.repository

import com.crype.passportofhealth.domain.model.VaccinationModel

interface VaccinationRepository {
    suspend fun getVaccinations(): List<VaccinationModel>
    suspend fun addVaccination(vaccination: VaccinationModel):Result<Unit>
    suspend fun updateVaccination(index: Int, vaccination: VaccinationModel):Result<Unit>
    suspend fun deleteVaccination(index: Int):Result<Unit>
}