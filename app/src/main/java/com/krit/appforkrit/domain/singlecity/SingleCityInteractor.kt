package com.krit.appforkrit.domain.singlecity

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.model.nw.weather.NwWeather
import com.krit.appforkrit.model.view_model.SingleCityViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SingleCityInteractor @Inject constructor(
    private val apiClient: ApiClient
) {

    fun getWeatherByLocationKey(locationKey: String, isFullInfo: Boolean): Single<List<NwWeather>> =
        apiClient.getWeatherByLocationKey(locationKey, isFullInfo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}