package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwWeather (
    @field:Json(name = "LocalObservationDateTime")
    val localObservationDateTime: String,

    @field:Json(name = "EpochTime")
    val epochTime: Int,

    @field:Json(name = "WeatherText")
    val weatherText: String? = null,

    @field:Json(name = "WeatherIcon")
    val weatherIcon: Int? = null,

    @field:Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean,

    @field:Json(name = "PrecipitationType")
    val precipitationType: String? = null,

    @field:Json(name = "IsDayTime")
    val isDayTime: Boolean,

    @field:Json(name = "Temperature")
    val temperature: MetricImperialJsonModel,

    @field:Json(name = "RealFeelTemperature")
    val realFeelTemperature: MetricImperialJsonModel,

    @field:Json(name = "RealFeelTemperatureShade")
    val realFeelTemperatureShade: MetricImperialJsonModel,

    @field:Json(name = "RelativeHumidity")
    val relativeHumidity: Int? = null,

    @field:Json(name = "DewPoint")
    val dewPoint: MetricImperialJsonModel,

    @field:Json(name = "Wind")
    val wind: NwWind,

    @field:Json(name = "WindGust")
    val windGust: NwWindGust,

    @field:Json(name = "UVIndex")
    val uVIndex: Int? = null,

    @field:Json(name = "UVIndexText")
    val uVIndexText: String,

    @field:Json(name = "Visibility")
    val visibility: MetricImperialJsonModel,

    @field:Json(name = "ObstructionsToVisibility")
    val obstructionsToVisibility: String? = null,

    @field:Json(name = "CloudCover")
    val cloudCover: Int? = null,

    @field:Json(name = "Ceiling")
    val ceiling: MetricImperialJsonModel,

    @field:Json(name = "Pressure")
    val pressure: MetricImperialJsonModel,

    @field:Json(name = "PressureTendency")
    val pressureTendency: NwPressureTendency,

    @field:Json(name = "Past24HourTemperatureDeparture")
    val past24HourTemperatureDeparture: MetricImperialJsonModel,

    @field:Json(name = "ApparentTemperature")
    val apparentTemperature: MetricImperialJsonModel,

    @field:Json(name = "WindChillTemperature")
    val windChillTemperature: MetricImperialJsonModel,

    @field:Json(name = "WetBulbTemperature")
    val wetBulbTemperature: MetricImperialJsonModel,

    @field:Json(name = "Precip1hr")
    val precip1hr: MetricImperialJsonModel,

    @field:Json(name = "PrecipitationSummary")
    val precipitationSummary: NwPrecipitationSummary,

    @field:Json(name = "TemperatureSummary")
    val temperatureSummary: NwTemperatureSummary,

    @field:Json(name = "MobileLink")
    val mobileLink: String,

    @field:Json(name = "Link")
    val link: String
)