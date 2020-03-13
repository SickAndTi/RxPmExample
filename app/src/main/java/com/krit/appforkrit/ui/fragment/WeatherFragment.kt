package com.krit.appforkrit.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krit.appforkrit.App
import com.krit.appforkrit.R
import com.krit.appforkrit.presentation.WeatherPm
import kotlinx.android.synthetic.main.fragment_weather.*
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
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

    @SuppressLint("SetTextI18n")
    override fun onBindPresentationModel(pm: WeatherPm) {

        pm.weather bindTo { it ->
            toolbar.title = it.cityName
            toolbar.subtitle = it.countryName
            toolbar.setNavigationOnClickListener { pm.backButtonPressed.consumer.accept(Unit) }
            temperatureValueTv.text = it.temperature.toString() + it.temperatureType
            weatherDescValueTv.text = it.weatherDesc
            isDayTimeTv.text = if(it.isDayTime) getString(R.string.day_text) else getString(R.string.night_text)
            val dateIn = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).parse(it.localObservationDateTime)
            val dateOut = SimpleDateFormat("dd EEE HH:mm", Locale.getDefault())
            currentTimeTv.text = dateOut.format(dateIn!!)
            windDirectionValueTv.text = it.windDirection
            windSpeedValueTv.text = it.windSpeed.toString() + it.windSpeedType
            relativeHumidityValueTv.text = it.relativeHumidity.toString()
            visibilityValueTv.text = it.visibility.toString() + it.visibilityType
            pressureValueTv.text = it.pressure.toString() + it.pressureType

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