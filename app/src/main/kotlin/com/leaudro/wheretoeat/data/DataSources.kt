package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place
import rx.Observable

interface PlacesDataSource {
    fun getPlaces(): Observable<List<Place>>
}