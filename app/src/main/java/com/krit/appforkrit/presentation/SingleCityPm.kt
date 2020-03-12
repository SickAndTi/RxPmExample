package com.krit.appforkrit.presentation

import com.krit.appforkrit.domain.singlecity.SingleCityInteractor
import io.reactivex.functions.BiConsumer
import me.dmdev.rxpm.PresentationModel
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

class SingleCityPm @Inject constructor(
    private val singleCityInteractor: SingleCityInteractor,
    private val router: Router
): PresentationModel() {

    override fun onCreate() {
        super.onCreate()
        Timber.d("On create: ${this::class.java}")

//        singleCityInteractor.getWeatherByLocationKey("308526", false)
//            .subscribe()
    }
}