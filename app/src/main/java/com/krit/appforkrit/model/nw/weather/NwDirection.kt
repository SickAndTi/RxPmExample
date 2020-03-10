package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwDirection (
    @field:Json(name = "Degrees")
    val degrees: Int? = null,

    @field:Json(name = "Localized")
    val localized: String,

    @field:Json(name = "English")
    val english: String
)
