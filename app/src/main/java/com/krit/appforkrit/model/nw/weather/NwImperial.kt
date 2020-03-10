package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwImperial (
    @field:Json(name = "Value")
    val value: Double? = null,

    @field:Json(name = "Unit")
    val unit: String,

    @field:Json(name = "UnitType")
    val unitType: Int
)
