package com.krit.appforkrit.presentation

import com.krit.appforkrit.Screens
import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.bindProgress
import me.dmdev.rxpm.state
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

class CityListPm @Inject constructor(
    private val cityListInteractor: CityListInteractor,
    private val router: Router
) : PresentationModel() {

    val cities = state {
        cityListInteractor.getCitiesFromApi("mos")
            .bindProgress(progressVisible.consumer)
            .toObservable()
    }

    val progressVisible = state(false)

    val citiesClicks = action<CityInListViewModel> {
        this.doOnNext { Timber.d("action: $it") }
            .doOnNext { router.navigateTo(Screens.SingleCityScreen(it.locationKey)) }
    }

    val searchTextChanged = action<String> {
        this.doOnNext { Timber.d("action: $it") }
            .doOnNext { cityListInteractor.getCitiesFromApi(it.toString()) }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.d("On create: ${this::class.java}")

    }

}