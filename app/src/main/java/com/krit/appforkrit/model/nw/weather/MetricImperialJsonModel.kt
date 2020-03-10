package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetricImperialJsonModel (
    @field:Json(name = "Metric")
    val metric: NwMetric,

    @field:Json(name = "Imperial")
    val imperial: NwImperial
)