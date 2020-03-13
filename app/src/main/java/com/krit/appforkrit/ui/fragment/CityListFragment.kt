package com.krit.appforkrit.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.jakewharton.rxbinding3.appcompat.queryTextChanges
import com.krit.appforkrit.App
import com.krit.appforkrit.R
import com.krit.appforkrit.presentation.CityListPm
import com.krit.appforkrit.ui.adapter.MyListItem
import com.krit.appforkrit.ui.adapter.delegate.cityAdapterDelegate
import kotlinx.android.synthetic.main.fragment_cities_list.*
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo
import timber.log.Timber
import javax.inject.Inject
import com.jakewharton.rxbinding3.view.visibility
import me.dmdev.rxpm.passTo

class CityListFragment: PmFragment<CityListPm>() {

    companion object {
        fun newInstance() = CityListFragment()
    }

    @Inject
    lateinit var cityListPm: CityListPm

    override fun onBindPresentationModel(pm: CityListPm) {
        pm.cities bindTo {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }

        pm.progressVisible bindTo progressBar.visibility()

        pm.progressVisible bindTo { cityListRecyclerView.visibility = if (it) View.GONE else View.VISIBLE }

        searchView.queryTextChanges() bindTo pm.searchTextChanged

        pm.errorState bindTo { Toast.makeText(context, it, Toast.LENGTH_LONG).show() }
    }

    override fun providePresentationModel(): CityListPm = cityListPm

    private lateinit var adapter: ListDelegationAdapter<List<MyListItem>>

    override fun onCreate(savedInstanceState: Bundle?) {
        App.COMPONENT.inject(this)
        super.onCreate(savedInstanceState)

        Timber.d("On create: ${this::class.java}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cities_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        cityListRecyclerView.layoutManager = LinearLayoutManager(activity)
        val delegateManager = AdapterDelegatesManager<List<MyListItem>>()
        delegateManager.addDelegate(cityAdapterDelegate {
            it passTo presentationModel.citiesClicks
        })
        adapter = ListDelegationAdapter(delegateManager)
        cityListRecyclerView.adapter = adapter
    }

}