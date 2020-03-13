package com.krit.appforkrit.presentation

import com.krit.appforkrit.domain.weather.WeatherInteractor
import com.krit.appforkrit.model.view_model.WeatherViewModel
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.state
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

class WeatherPm @Inject constructor(
    private val weatherInteractor: WeatherInteractor,
    private val router: Router
): PresentationModel() {

    lateinit var locationKey: String

    override fun onCreate() {
        super.onCreate()
        Timber.d("On create: ${this::class.java}")
        Timber.d("locationKey From Pm: $locationKey")

    }

    val weather = state<WeatherViewModel> {
        weatherInteractor.getWeatherFromDb(locationKey)
            .toObservable()
    }

}