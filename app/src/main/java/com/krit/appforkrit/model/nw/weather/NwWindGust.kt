package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwWindGust (
    @field:Json(name = "Speed")
    val speed: MetricImperialJsonModel
)
