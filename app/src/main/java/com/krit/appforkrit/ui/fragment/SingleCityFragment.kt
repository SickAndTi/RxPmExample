package com.krit.appforkrit.ui.fragment

import android.os.Bundle
import com.krit.App
import com.krit.appforkrit.presentation.SingleCityPm
import me.dmdev.rxpm.base.PmFragment
import timber.log.Timber
import javax.inject.Inject

class SingleCityFragment: PmFragment<SingleCityPm>() {

    companion object {
        private const val ARG_LOCATION_KEY = "ARG_LOCATION_KEY"

        fun newInstance(locationKey: Long): SingleCityFragment {
            Timber.d("newInstance: $locationKey")
            val fragment = SingleCityFragment()
            val args = Bundle()
            args.putLong(ARG_LOCATION_KEY, locationKey)
            fragment.arguments = args
            return fragment
        }
    }

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