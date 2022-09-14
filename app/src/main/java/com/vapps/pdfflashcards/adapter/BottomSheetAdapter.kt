package com.vapps.pdfflashcards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vapps.pdfflashcards.R

class BottomSheetAdapter(val itemList: List<String>, val clickListener: (name: String) -> Unit) : RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder>() {

    val data = itemList


    class BottomSheetViewHolder(val textItem: TextView) : RecyclerView.ViewHolder(textItem) {


        companion object {
            fun inflateFrom(parent: ViewGroup): BottomSheetViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.bottom_sheet_items, parent, false) as TextView
                return BottomSheetViewHolder(view)
            }
        }

        fun bind(item: String, clickListener: (name: String) -> Unit) {
            textItem.text = item
            textItem.setOnClickListener { clickListener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder = BottomSheetViewHolder.inflateFrom(parent)


    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount(): Int = data.size

}