package com.krit.appforkrit.model.view_model

data class WeatherViewModel (
    val cityName: String,
    val countryName: String,
    val temperature: Double? = null,
    val temperatureType: String,
    val weatherDesc: String? = null,
    val localObservationDateTime: String,
    val isDayTime: Boolean,
    val relativeHumidity: Int? = null,
    val windDirection: String? = null,
    val windSpeed: Double? = null,
    val windSpeedType: String,
    val visibility: Double?,
    val visibilityType: String,
    val pressure: Double?,
    val pressureType: String
)