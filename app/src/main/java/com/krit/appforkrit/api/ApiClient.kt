package com.krit.appforkrit.api

import com.krit.appforkrit.model.nw.weather.NwWeather
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val api: Api
) {

    fun autocompleteCities(textToSearch: String) = api.autocompleteCities(textToSearch)

    fun searchCities(textToSearch: String) = api.searchCities(textToSearch)

    fun getWeatherByLocationKey(locationKey: String, fullInfo: Boolean): Single<List<NwWeather>> = api.getWeatherByLocationKey(locationKey, fullInfo)
}