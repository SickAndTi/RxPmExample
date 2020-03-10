package com.krit.appforkrit.ui.fragment

import android.os.Bundle
import com.krit.App
import com.krit.appforkrit.presentation.CityListPm
import com.krit.appforkrit.presentation.SingleCityPm
import me.dmdev.rxpm.base.PmFragment
import timber.log.Timber
import javax.inject.Inject

class SingleCityFragment: PmFragment<SingleCityPm>() {

    @Inject
    lateinit var singleCityPm: SingleCityPm

    override fun onBindPresentationModel(pm: SingleCityPm) {

    }

    override fun providePresentationModel(): SingleCityPm = singleCityPm

    override fun onCreate(savedInstanceState: Bundle?) {
        App.COMPONENT.inject(this)
        super.onCreate(savedInstanceState)

        Timber.d("On create: ${this::class.java}")
    }
}