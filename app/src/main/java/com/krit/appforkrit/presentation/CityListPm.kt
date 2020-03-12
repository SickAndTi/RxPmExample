package com.krit.appforkrit.presentation

import com.krit.appforkrit.Screens
import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import io.reactivex.Single
import me.dmdev.rxpm.*
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CityListPm @Inject constructor(
    private val cityListInteractor: CityListInteractor,
    private val router: Router
) : PresentationModel() {

    val cities = state<List<CityInListViewModel>>(emptyList())
//    {
//        searchTextChanged.observable
//            .flatMapSingle {
//                if (it.isEmpty()) {
//                    Single.just(emptyList())
//                } else {
//                    cityListInteractor.getCitiesFromApi(it.toString())
//                        .bindProgress(progressVisible.consumer)
//                }
//            }
//    }

    val progressVisible = state(false)

    val citiesClicks = action<CityInListViewModel> {
        this.doOnNext { Timber.d("action: $it") }
            .doOnNext { router.navigateTo(Screens.SingleCityScreen(it.locationKey)) }
    }

    val searchTextChanged = action<CharSequence> {
        this.debounce(300, TimeUnit.MILLISECONDS)
            .doOnNext { Timber.d("action: $it") }
            .flatMapSingle {
                if (it.isEmpty()) {
                    Single.just(emptyList())
                } else {
                    cityListInteractor.getCitiesFromApi(it.toString())
                        .bindProgress(progressVisible.consumer)
                }
            }
            .doOnNext(cities.consumer::accept)
            .doOnError{
                errorCommand.accept(it.message ?: "Unexpected error!")
            }
    }

    val errorCommand = command<String>()

    override fun onCreate() {
        super.onCreate()

        Timber.d("On create: ${this::class.java}")

    }

}