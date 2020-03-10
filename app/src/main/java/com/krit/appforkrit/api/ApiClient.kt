package com.krit.appforkrit.api

import javax.inject.Inject

class ApiClient @Inject constructor(
    private val api: Api
) {

    fun autocompleteCities(textToSearch: String) = api.autocompleteCities(textToSearch)

    fun searchCities(textToSearch: String) = api.searchCities(textToSearch)

    fun getWeatherByLocationKey(fullInfo: Boolean, locationKey: Long) = api.getWeatherByLocationKey(fullInfo, locationKey)
}