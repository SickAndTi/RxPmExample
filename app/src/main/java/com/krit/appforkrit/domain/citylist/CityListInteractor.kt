package com.krit.appforkrit.domain.citylist

import com.krit.appforkrit.api.ApiClient
import com.krit.appforkrit.db.AppDatabase
import com.krit.appforkrit.ui.adapter.view_model.CityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityListInteractor @Inject constructor(
    private val apiClient: ApiClient,
    private val appDatabase: AppDatabase
) {

    fun getCitiesFromApi() = apiClient.autocompleteCities("mos")
        .map { cities ->
            cities.map {
                CityViewModel(
                    name = it.localizedName
                )
            }
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}