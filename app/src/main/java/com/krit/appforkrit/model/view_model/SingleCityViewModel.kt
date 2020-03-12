package com.krit.appforkrit.model.view_model

data class SingleCityViewModel (
    val cityName: String,
    val countryName: String,
    val temperature: Double? = null,
    val weatherDesc: String,
    val localObservationDateTime: String,
    val isDayTime: Boolean,
    val relativeHumidity: Int? = null,
    val windDirection: String? = null,
    val windSpeed: Double? = null,
    val visibility: Double?,
    val pressure: Double?
)