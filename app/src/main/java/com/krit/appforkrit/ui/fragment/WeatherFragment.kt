package com.krit.appforkrit.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krit.appforkrit.App
import com.krit.appforkrit.R
import com.krit.appforkrit.presentation.WeatherPm
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.fragment_weather.temperatureNameTv
import kotlinx.android.synthetic.main.fragment_weather.weatherDescTv
import kotlinx.android.synthetic.main.item_city.*
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo
import timber.log.Timber
import javax.inject.Inject

class WeatherFragment: PmFragment<WeatherPm>() {

    companion object {
        private const val ARG_LOCATION_KEY = "ARG_LOCATION_KEY"

        fun newInstance(locationKey: String): WeatherFragment {
            Timber.d("newInstance: $locationKey")
            val fragment = WeatherFragment()
            val args = Bundle()
            args.putString(ARG_LOCATION_KEY, locationKey)
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var weatherPm: WeatherPm

    override fun onBindPresentationModel(pm: WeatherPm) {

        pm.weather bindTo {
            toolbar.title = it.cityName
            toolbar.subtitle = it.countryName
            toolbar.setNavigationOnClickListener { pm.backButtonPressed.consumer.accept(Unit) }
            temperatureNameTv.text = it.temperature.toString()
            weatherDescTv.text = it.weatherDesc
            isDayTimeTv.text = if(it.isDayTime) getString(R.string.day_text) else getString(R.string.night_text)
            currentTimeTv.text = it.localObservationDateTime
            windDirectionTv.text = it.windDirection
            windSpeedTv.text = it.windSpeed.toString()
            relativeHumidityValueTv.text = it.relativeHumidity.toString()
            visibilityValueTv.text = it.visibility.toString()
            pressureValueTv.text = it.pressure.toString()

        }
    }

    override fun providePresentationModel(): WeatherPm  {
        weatherPm.locationKey = requireArguments().getString(ARG_LOCATION_KEY, null)
        return weatherPm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.COMPONENT.inject(this)
        super.onCreate(savedInstanceState)

        Timber.d("On create: ${this::class.java}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_weather, container, false)

}