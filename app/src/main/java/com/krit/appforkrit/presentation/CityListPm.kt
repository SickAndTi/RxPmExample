package com.krit.appforkrit.presentation

import me.dmdev.rxpm.PresentationModel
import timber.log.Timber

class CityListPm: PresentationModel() {

    override fun onCreate() {
        super.onCreate()
        Timber.d("On create: ${this::class.java}")
    }

}