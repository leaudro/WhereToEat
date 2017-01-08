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

    private var enableButtons: Boolean = true

    override fun onBindViewHolder(holder: PlacesViewHolder?, position: Int) {

        holder?.let {
            val place = list[position]
            it.textName.text = place.name
            it.textDescription.text = place.description
            it.button.setOnClickListener {
                onButtonClicked?.invoke(place, position)
            }

            it.button.isEnabled = enableButtons && !place.chosenThisWeek

            with(it.textObservation) {
                if (place.votedByYou) {
                    visibility = View.VISIBLE
                    setText(R.string.msg_you_already_voted)
                } else if (place.chosenThisWeek) {
                    visibility = View.VISIBLE
                    setText(R.string.msg_chosen_this_week)
                } else {
                    visibility = View.GONE
                }
            }

            val resources = it.textVotes.resources
            it.textVotes.text = if (place.votesReceived > 0)
                resources.getQuantityString(R.plurals.x_votes_received,
                        place.votesReceived,
                        place.votesReceived)
            else resources.getString(R.string.no_votes_received)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): PlacesViewHolder {

        return PlacesViewHolder(inflater.inflate(R.layout.item_place, parent, false))
    }

    fun disableVotingButtons() {
        enableButtons = false
        notifyDataSetChanged()
    }
}

class PlacesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var image: ImageView = view.image
    var button: Button = view.buttonVote
    var textName: TextView = view.textName
    var textDescription: TextView = view.textDescription
    var textObservation: TextView = view.textObservation
    var textVotes: TextView = view.textVotes
}
