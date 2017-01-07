package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place
import rx.Observable
import rx.lang.kotlin.toSingletonObservable
import java.util.concurrent.TimeUnit

class PlacesRepository : PlacesDataSource {
        private val placesList = listOf(Place(0, "Restaurante 1", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta"),
                Place(1, "Restaurante 2", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta"),
                Place(2, "Restaurante 3", "Restaurante\n de comida baiana\n com ótimos aperitivos. \nPromoção toda sexta"))

    override fun getPlaces(): Observable<List<Place>> {
        return placesList.toSingletonObservable().delay(5, TimeUnit.SECONDS)
    }

}