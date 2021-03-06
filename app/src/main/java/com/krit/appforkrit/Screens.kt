package com.krit.appforkrit

import com.krit.appforkrit.ui.fragment.CityListFragment
import com.krit.appforkrit.ui.fragment.WeatherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object CityListScreen : SupportAppScreen() {
        override fun getFragment() = CityListFragment.newInstance()
    }

    data class SingleCityScreen(val locationKey: String) : SupportAppScreen() {
        override fun getFragment() = WeatherFragment.newInstance(locationKey)
    }
}