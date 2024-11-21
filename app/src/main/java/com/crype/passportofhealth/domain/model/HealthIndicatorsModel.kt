package com.crype.passportofhealth.domain.model

data class HealthIndicatorsModel(
    val weight: Float,
    val height: Float,
    var highPressure: Int,
    var lowPressure: Int,
    val glucose: Float,   //70 - 110 мг/дл
    val cholesterol: Float   //3.6 - 5.2 ммоль/л
)
