package com.krit.appforkrit.presentation

import com.krit.appforkrit.Screens
import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import me.dmdev.rxpm.*
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CityListPm @Inject constructor(
    private val cityListInteractor: CityListInteractor,
    private val router: Router
) : PresentationModel() {

    sealed class DownloadState {
        object Initial: DownloadState()
        object Loading: DownloadState()
        class Finished(val cities: List<CityInListViewModel>) : DownloadState()
        class Error(val errorMessage: String) : DownloadState()
    }

    private val downloadState = state<DownloadState>(DownloadState.Initial)

    val cities = state<List<CityInListViewModel>>{
        downloadState.observable
            .filter { it is DownloadState.Finished }
            .map { it as DownloadState.Finished }
            .map { it.cities }
    }

    val progressVisible = state {
        this.downloadState.observable
            .map { downloadState ->
                when (downloadState) {
                    is DownloadState.Loading -> true
                    else -> false
                }
            }
    }

    val citiesClicks = action<CityInListViewModel> {
        this.doOnNext { Timber.d("action: $it") }
            .doOnNext { router.navigateTo(Screens.SingleCityScreen(it.locationKey)) }
    }

    val searchTextChanged = action<CharSequence> {
        this.debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .doOnNext { Timber.d("action: $it") }
            .doOnNext { downloadState.accept(DownloadState.Loading) }
            .flatMapSingle { queryText ->
                if (queryText.isEmpty()) {
                    cityListInteractor.getAllFromDb()
                } else {
                    cityListInteractor.getCitiesFromApi(queryText.toString())
                        .doOnError { downloadState.accept(DownloadState.Error(it.message ?: "Unexpected error!")) }
                        .onErrorResumeNext {
                            cityListInteractor.searchFromDb(queryText.toString())
                                .doOnSuccess { Timber.d("INFO: $it") }
                        }
                }
            }
            .doOnNext { downloadState.accept(DownloadState.Finished(it)) }
    }

    val errorState = state<String> {
        downloadState.observable
            .filter { it is DownloadState.Error }
            .map { it as DownloadState.Error }
            .map { it.errorMessage }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.d("On create: ${this::class.java}")

    }

}