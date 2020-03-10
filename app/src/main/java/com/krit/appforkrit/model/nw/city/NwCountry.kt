package com.krit.appforkrit.model.nw.city

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwCountry (
    @field:Json(name = "ID")
    val id: String,

    @field:Json(name = "LocalizedName")
    val localizedName: String
)