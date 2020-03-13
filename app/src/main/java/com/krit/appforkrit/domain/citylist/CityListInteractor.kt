package com.krit.appforkrit.domain.citylist

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.db.AppDatabase
import com.krit.appforkrit.domain.weather.WeatherInteractor
import com.krit.appforkrit.model.db.City
import com.krit.appforkrit.model.db.Weather
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityListInteractor @Inject constructor(
    private val apiClient: ApiClient,
    private val weatherInteractor: WeatherInteractor,
    private val appDatabase: AppDatabase
) {
    fun getCitiesFromApi(textToSearch: String) =
        apiClient.autocompleteCities(textToSearch)
            .map { listNwCty ->
                listNwCty.map { nwCity ->
                    City(
                        locationKey = nwCity.key,
                        name = nwCity.localizedName,
                        countryName = nwCity.country.localizedName
                    )
                }
            }
            .doOnSuccess { appDatabase.cityDao().insertAll(it) }
            .flatMap { cities ->
                Flowable.fromIterable(cities)
                    .flatMapSingle { city ->
                        weatherInteractor.getWeatherByLocationKey(city.locationKey, true)
                                //cause api gives array with one element for this request
                            .map { it.first() }
                            .map {
                                Weather(
                                    locationKey = city.locationKey,
                                    weatherDesc = it.weatherText,
                                    temperature = it.temperature.metric.value,
                                    isDayTime = it.isDayTime,
                                    localObservationDateTime = it.localObservationDateTime,
                                    pressure = it.pressure.metric.value,
                                    relativeHumidity = it.relativeHumidity,
                                    visibility = it.visibility.metric.value,
                                    windDirection = it.wind.direction.english,
                                    windSpeed = it.wind.speed.metric.value
                                )
                            }
                            .doOnSuccess { appDatabase.weatherDao().insert(it) }
                    }
                    .toList()
            }
            .map { weatherList -> weatherList.map { it.locationKey } }
            .flatMap { appDatabase.cityDao().getCitiesWithWeatherByLocationKeys(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getAllFromDb() = appDatabase.cityDao().getCitiesWithWeather()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}