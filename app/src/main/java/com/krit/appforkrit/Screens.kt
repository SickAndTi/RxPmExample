package com.krit.appforkrit

import com.krit.appforkrit.ui.fragment.CityListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object CityListScreen : SupportAppScreen() {
        override fun getFragment() = CityListFragment.newInstance()
    }
}