package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place

interface PlacesDataSource {
    fun getPlaces(): List<Place>
}