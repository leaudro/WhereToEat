package com.leaudro.wheretoeat.ui.places

import com.leaudro.wheretoeat.data.PlacesDataSource


class PlacesPresenter(val view: PlacesContract.View,
                      val dataSource: PlacesDataSource) : PlacesContract.Presenter {

    override fun fetchPlaces() {
        view.showLoadingIndicator(true)

        val places = dataSource.getPlaces()

        if (places.isEmpty()) {
            view.showEmptyList()
        } else {
            view.showPlaces(places)
        }

        view.showLoadingIndicator(false)
    }

}