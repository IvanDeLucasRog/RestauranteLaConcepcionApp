package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.R
import com.platzi.conf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    private var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_speaker, parent, false))

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeakers[position]
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerWork.text = speaker.workplace

        //dependencia que nos permite descargar imagenes
        Glide.with(holder.itemView.context) //contexto
            .load(speaker.image) // donde esta la imagen
            .apply(RequestOptions.circleCropTransform()) //atributo interno de glide para hacerlo circular
            .into(holder.ivSpeakerImage) //dondecolocarla

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }
    }

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)
        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
    }
}