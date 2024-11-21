package com.crype.passportofhealth.domain.model

data class LifestyleModel(
    val typeOfNutrition: String,
    val modeOfNutrition: String,
    val smoking:String,
    val alcohol: String,
    val drugs: String,
    val physicalActivity: String,
    val frequencyOfPhysical: String
)
