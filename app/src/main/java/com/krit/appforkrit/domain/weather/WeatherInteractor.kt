package com.krit.appforkrit.domain.weather

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.model.nw.weather.NwWeather
import io.reactivex.Single
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val apiClient: ApiClient
) {

    fun getWeatherByLocationKey(locationKey: String, isFullInfo: Boolean): Single<List<NwWeather>> =
        apiClient.getWeatherByLocationKey(locationKey, isFullInfo)
}