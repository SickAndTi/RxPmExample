package com.krit.appforkrit.domain.citylist

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.db.AppDatabase
import com.krit.appforkrit.domain.singlecity.SingleCityInteractor
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityListInteractor @Inject constructor(
    private val apiClient: ApiClient,
    private val singleCityInteractor: SingleCityInteractor,
    private val appDatabase: AppDatabase
) {
    fun getCitiesFromApi(textToSearch: String) =
        apiClient.autocompleteCities(textToSearch)
            .flatMap { cities ->
                Flowable.fromIterable(cities)
                    .flatMapSingle { nwCity ->
                        singleCityInteractor.getWeatherByLocationKey(nwCity.key, true)
                            .map { it.first() }
                            .map {
                                CityInListViewModel(
                                    cityName = nwCity.localizedName,
                                    countryName = nwCity.country.localizedName,
                                    temperature = it.temperature.metric.value,
                                    weatherDesc = it.weatherText,
                                    locationKey = nwCity.key
                                )
                            }
                    }
                    .toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}