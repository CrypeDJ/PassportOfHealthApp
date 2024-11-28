package com.crype.passportofhealth.domain.model

data class HealthIndicatorsModel(
    var weight: String,
    var height: String,
    var highPressure: String,
    var lowPressure: String,
    var glucose: String,   //70 - 110 мг/дл
    var cholesterol: String   //3.6 - 5.2 ммоль/л
)
