package com.krit.appforkrit.presentation

import android.content.Context
import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.ui.adapter.view_model.CityViewModel
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.bindProgress
import me.dmdev.rxpm.state
import timber.log.Timber
import javax.inject.Inject

class CityListPm @Inject constructor(
    private val cityListInteractor: CityListInteractor
) : PresentationModel() {

    val cities = state {
        cityListInteractor.getCitiesFromApi()
            .bindProgress(progressVisible.consumer)
            .toObservable()
    }

    val progressVisible = state(false)

    val citiesClicks = action<CityViewModel> {
        this.doOnNext { Timber.d("action: $it") }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.d("On create: ${this::class.java}")

    }

}