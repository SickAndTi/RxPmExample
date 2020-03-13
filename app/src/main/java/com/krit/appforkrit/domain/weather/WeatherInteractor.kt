package com.krit.appforkrit.domain.weather

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.db.AppDatabase
import com.krit.appforkrit.model.nw.weather.NwWeather
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val apiClient: ApiClient,
    private val appDatabase: AppDatabase
) {

    fun getWeatherByLocationKey(locationKey: String, isFullInfo: Boolean): Single<List<NwWeather>> =
        apiClient.getWeatherByLocationKey(locationKey, isFullInfo)

    fun getWeatherFromDb(locationKey: String) =
        appDatabase.weatherDao().getWeatherAndCityByLocationKey(locationKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}