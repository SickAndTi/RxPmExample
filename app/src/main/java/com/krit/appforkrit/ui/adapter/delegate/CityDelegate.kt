package com.krit.appforkrit.ui.adapter.delegate

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.krit.appforkrit.R
import com.krit.appforkrit.ui.adapter.MyListItem
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import kotlinx.android.synthetic.main.item_city.view.*

fun cityAdapterDelegate(itemClickedListener: (CityInListViewModel) -> Unit) =
    adapterDelegateLayoutContainer<CityInListViewModel, MyListItem>(R.layout.item_city) {

        bind {
            with(itemView){
                cityNameTv.text = item.cityName
                countryNameTv.text = item.countryName
                temperatureValueTv.text = item.temperature.toString()
                weatherDescValueTv.text = item.weatherDesc
                setOnClickListener { itemClickedListener(item) }
            }
        }
    }