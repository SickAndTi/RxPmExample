package com.krit.appforkrit.ui.fragment

import android.os.Bundle
import com.krit.App
import com.krit.appforkrit.presentation.CityListPm
import me.dmdev.rxpm.base.PmFragment
import timber.log.Timber
import javax.inject.Inject

class CityListFragment: PmFragment<CityListPm>() {

    companion object {
        fun newInstance() = CityListFragment()
    }

    @Inject
    lateinit var cityListPm: CityListPm

    override fun onBindPresentationModel(pm: CityListPm) {

    }

    override fun providePresentationModel(): CityListPm {
//        App.COMPONENT.inject(this)
        return cityListPm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.COMPONENT.inject(this)
        super.onCreate(savedInstanceState)

        Timber.d("On create: ${this::class.java}")

    }
}