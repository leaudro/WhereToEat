package com.leaudro.wheretoeat.ui.places

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leaudro.wheretoeat.R
import com.leaudro.wheretoeat.data.model.Place

class PlacesAdapter(context: Context) : RecyclerView.Adapter<PlacesViewHolder>() {

    var list: List<Place> = emptyList()
        set(value) {
            val size = field.size
            field = value

            notifyItemRangeRemoved(0, size)
            notifyItemRangeInserted(0, value.size)
        }

    var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: PlacesViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): PlacesViewHolder {

        return PlacesViewHolder(inflater.inflate(R.layout.item_place, parent, false))
    }
}

class PlacesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
