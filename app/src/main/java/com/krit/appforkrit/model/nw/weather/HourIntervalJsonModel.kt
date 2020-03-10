package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourIntervalJsonModel (
    @field:Json(name = "Minimum")
    val minimum: MetricImperialJsonModel,

    @field:Json(name = "Maximum")
    val maximum: MetricImperialJsonModel
)