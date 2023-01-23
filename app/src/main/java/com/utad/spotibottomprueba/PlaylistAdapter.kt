package com.utad.spotibottomprueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaylistAdapter(private val playlist:ArrayList<Playlist>) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    var onItemClick : ((Playlist) -> Unit)? = null

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val txtView : TextView = itemView.findViewById(R.id.txtSong)
        val txtView2 : TextView = itemView.findViewById(R.id.txtSinger)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block , parent , false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlist[position]
        holder.txtView.text = playlist.name
        holder.txtView2.text = playlist.subs
        holder.imageView.setImageResource(playlist.image)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(playlist)
        }
    }

    override fun getItemCount(): Int {
        return playlist.size
    }
}