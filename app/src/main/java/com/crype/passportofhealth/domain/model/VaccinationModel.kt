package com.crype.passportofhealth.domain.model

data class VaccinationModel(
    var type: String,
    var name: String,
    var date: String,
    var series: String,
    var reaction: String
)
