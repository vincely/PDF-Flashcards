package com.vapps.pdfflashcards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vapps.pdfflashcards.R
import com.vapps.pdfflashcards.data.Card
import com.vapps.pdfflashcards.data.Deck
import com.vapps.pdfflashcards.data.TestData

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {

    val data = TestData.data


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder = CardsViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = data.size



    class CardsViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
        val deckName = rootView.findViewById<TextView>(R.id.deck_title)
        val deckStats = rootView.findViewById<TextView>(R.id.deck_stats)

        companion object {
            fun inflateFrom(parent: ViewGroup) : CardsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.deck_item, parent, false) as CardView
                return CardsViewHolder(view)
            }
        }

        fun bind(item: Deck) {
            deckName.text = item.deckName
            deckStats.text = "Decksize: ${item.deckSize}"
        }

    }
}