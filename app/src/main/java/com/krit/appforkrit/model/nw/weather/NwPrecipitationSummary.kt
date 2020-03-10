package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwPrecipitationSummary (
    @field:Json(name = "Precipitation")
    val precipitation: MetricImperialJsonModel,

    @field:Json(name = "PastHour")
    val pastHour: MetricImperialJsonModel,

    @field:Json(name = "Past3Hours")
    val past3Hours: MetricImperialJsonModel,

    @field:Json(name = "Past6Hours")
    val past6Hours: MetricImperialJsonModel,

    @field:Json(name = "Past9Hours")
    val past9Hours: MetricImperialJsonModel,

    @field:Json(name = "Past12Hours")
    val past12Hours: MetricImperialJsonModel,

    @field:Json(name = "Past18Hours")
    val past18Hours: MetricImperialJsonModel,

    @field:Json(name = "Past24Hours")
    val past24Hours: MetricImperialJsonModel
)
