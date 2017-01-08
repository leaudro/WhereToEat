package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place
import rx.Observable
import rx.lang.kotlin.toSingletonObservable
import java.util.concurrent.TimeUnit

class PlacesRepository : PlacesDataSource {
        private val placesList = listOf(Place(0, "Restaurante 1", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta", 3, false, false),
                Place(1, "Restaurante 2", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta", 0, false, true),
                Place(2, "Restaurante 3", "Restaurante\n de comida baiana\n com ótimos aperitivos. \nPromoção toda sexta", 1, false, false),
                Place(3, "Restaurante 4", "Restaurante de comida baiana com ótimos aperitivos. \nPromoção toda sexta", 6, false, false),
                Place(4, "Restaurante 5", "Restaurante", 0, false, true))

    override fun getPlaces(): Observable<List<Place>> {
        return placesList.toSingletonObservable().delay(5, TimeUnit.SECONDS)
    }
}