package com.krit.appforkrit.ui.adapter.delegate

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.krit.appforkrit.R
import com.krit.appforkrit.ui.adapter.MyListItem
import com.krit.appforkrit.ui.adapter.view_model.CityViewModel
import kotlinx.android.synthetic.main.item_city.view.*

fun cityAdapterDelegate(itemClickedListener: (CityViewModel) -> Unit) =
    adapterDelegateLayoutContainer<CityViewModel, MyListItem>(R.layout.item_city) {

        bind {
            itemView.cityNameTv.text = item.name
            itemView.setOnClickListener { itemClickedListener(item) }
        }
    }