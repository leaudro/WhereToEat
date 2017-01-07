package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place

class PlacesRepository : PlacesDataSource {
    override fun getPlaces() = emptyList<Place>()

}