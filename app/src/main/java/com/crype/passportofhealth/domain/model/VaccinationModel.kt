package com.crype.passportofhealth.domain.model

data class VaccinationModel(
    val type: String = "",
    val name: String = "",
    val date: String = "",
    val series: String = "",
    val reaction: String = ""
)
