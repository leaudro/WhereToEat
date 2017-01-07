package com.leaudro.wheretoeat.ui.places

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.leaudro.wheretoeat.R
import com.leaudro.wheretoeat.data.model.Place
import kotlinx.android.synthetic.main.item_place.view.*

class PlacesAdapter(context: Context) : RecyclerView.Adapter<PlacesViewHolder>() {

    var list: List<Place> = emptyList()
        set(value) {
            val size = field.size
            field = value

            notifyItemRangeRemoved(0, size)
            notifyItemRangeInserted(0, value.size)
        }

    var inflater: LayoutInflater = LayoutInflater.from(context)

    var onButtonClicked: ((Place, position: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: PlacesViewHolder?, position: Int) {

        holder?.let {
            val place = list[position]
            it.textName.text = place.name
            it.textDescription.text = place.description
            it.button.setOnClickListener {
                onButtonClicked?.invoke(place, position)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): PlacesViewHolder {

        return PlacesViewHolder(inflater.inflate(R.layout.item_place, parent, false))
    }
}

class PlacesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var textName: TextView = view.textName
    var textDescription: TextView = view.textDescription
    var image: ImageView = view.image
    var button: Button = view.buttonVote

}
