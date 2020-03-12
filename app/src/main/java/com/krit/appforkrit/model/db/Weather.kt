package com.krit.appforkrit.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weathers")
data class Weather (
    @PrimaryKey
    val id: Int,

    val temperature: Double? = null,
    val weatherDesc: String,
    val localObservationDateTime: String,
    val isDayTime: Boolean,
    val relativeHumidity: Int? = null,
    val windDirection: String? = null,
    val windSpeed: Double? = null,
    val visibility: Double? = null,
    val pressure: Double? = null
)