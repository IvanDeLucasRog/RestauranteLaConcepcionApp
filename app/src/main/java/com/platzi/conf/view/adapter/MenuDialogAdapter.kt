package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import com.platzi.conf.model.Plates

class MenuDialogAdapter : RecyclerView.Adapter<MenuDialogAdapter.ViewHolder>() {

    var listPlates = ArrayList<Plates>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MenuDialogAdapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_detail_menu, parent, false)
    )

    override fun getItemCount() = listPlates.size

    override fun onBindViewHolder(holder: MenuDialogAdapter.ViewHolder, position: Int) {
        val plate = listPlates[position] as Plates
        holder.tvDetailMenuPlate.text = plate.plato
        holder.tvDetailMenuPrice.text = plate.precio
    }
    fun updateData(data: List<Plates>) {
        listPlates.clear()
        listPlates.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvDetailMenuPlate = itemView.findViewById<TextView>(R.id.tvDetailMenuPlate)
        val tvDetailMenuPrice = itemView.findViewById<TextView>(R.id.tvDetailMenuPrice)
    }
}