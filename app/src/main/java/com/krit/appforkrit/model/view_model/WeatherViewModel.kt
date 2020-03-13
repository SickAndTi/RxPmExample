package com.krit.appforkrit.model.view_model

data class WeatherViewModel (
    val cityName: String,
    val countryName: String,
    val temperature: Double? = null,
    val weatherDesc: String? = null,
    val localObservationDateTime: String,
    val isDayTime: Boolean,
    val relativeHumidity: Int? = null,
    val windDirection: String? = null,
    val windSpeed: Double? = null,
    val visibility: Double?,
    val pressure: Double?
)