package com.crype.passportofhealth.domain.model

data class DiseaseClass(
    val name: String,
    val data: String,
    val status: String,
    val symptoms: String,
    val treatment: String,
    val nameOfDoctor: String,
    val contactOfDoctor: String
)