package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwTemperatureSummary (
    @field:Json(name = "Past6HourRange")
    val past6HourRange: HourIntervalJsonModel,

    @field:Json(name = "Past12HourRange")
    val past12HourRange: HourIntervalJsonModel,

    @field:Json(name = "Past24HourRange")
    val past24HourRange: HourIntervalJsonModel
)
