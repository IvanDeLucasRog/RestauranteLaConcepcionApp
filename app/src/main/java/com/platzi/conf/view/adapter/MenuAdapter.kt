package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.model.Menu
import com.platzi.conf.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MenuAdapter(val menuListener: MenuListener) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    var listMenu = ArrayList<Menu>() //donde se van a almacenar gráficamente los elementos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false))
        // Diseño para nuestra lista. Asignamos el item que crearmos
    override fun getItemCount() = listMenu.size
        //Cuantos elementos tenemos
    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) { //Como podemos enlazar cada elemento
        val menu = listMenu[position] as Menu //situarnos en el item que estemos

        holder.tvItemMenuPlatesName.text = menu.title
        holder.tvItemMenuTag.text = menu.tag
        Picasso.get().load(menu.imageUrl).into(holder.ivItemMenuIcon)

        holder.itemView.setOnClickListener {
            menuListener.onMenuClicked(menu, position)
        }

    }

    fun updateData(data: List<Menu>) {
        listMenu.clear()
        listMenu.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemMenuPlatesName = itemView.findViewById<TextView>(R.id.tvItemMenuPlatesName)
        val tvItemMenuTag = itemView.findViewById<TextView>(R.id.tvItemMenuTag)
        val ivItemMenuIcon = itemView.findViewById<ImageView>(R.id.ivItemMenuIcon)
    }

}