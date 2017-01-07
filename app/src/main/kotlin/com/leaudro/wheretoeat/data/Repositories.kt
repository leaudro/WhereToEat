package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.data.model.Place

class PlacesRepository : PlacesDataSource {
    override fun getPlaces(): List<Place> {
        return listOf(Place(0, "Restaurante 1", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta"),
                Place(1, "Restaurante 2", "Restaurante de comida baiana com ótimos aperitivos. Promoção toda sexta"),
                Place(2, "Restaurante 3", "Restaurante\n de comida baiana\n com ótimos aperitivos. \nPromoção toda sexta"))
    }

}