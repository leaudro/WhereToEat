package com.leaudro.wheretoeat.ui.places

import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.ui.BaseView

interface PlacesContract {

    interface View : BaseView {
        fun showPlaces(list: List<Place>)
        fun showEmptyList()
        fun blockVoting()
    }

    interface Presenter {
        fun fetchPlaces()
    }
}