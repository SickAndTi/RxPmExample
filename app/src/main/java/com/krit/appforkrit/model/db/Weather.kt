package com.krit.appforkrit.model.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "weathers",
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            childColumns = ["locationKey"],
            parentColumns = ["locationKey"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Weather (
    @PrimaryKey(autoGenerate = false)
    val locationKey: String,

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