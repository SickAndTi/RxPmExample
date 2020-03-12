package com.krit.appforkrit.ui.adapter.view_model

import com.krit.appforkrit.ui.adapter.MyListItem

data class CityInListViewModel (
    val cityName: String,
    val countryName: String,
    val temperature: Double?,
    val weatherDesc: String,
    val locationKey: String
):MyListItem