package com.crype.passportofhealth.domain.model

data class HealthIndicatorsModel(
    val weight: String = "",
    val height: String = "",
    val highPressure: String = "",
    val lowPressure: String = "",
    val glucose: String = "",           //70 - 110 мг/дл
    val cholesterol: String = ""        //3.6 - 5.2 ммоль/л
)
