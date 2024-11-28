package com.crype.passportofhealth.domain.model

data class DiseaseModel(
    var name: String,
    var date: String,
    var status: String,
    var symptoms: String,
    var treatment: String,
    var nameOfDoctor: String,
    var contactOfDoctor: String
)