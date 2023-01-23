package com.utad.spotibottomprueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private val musicList:ArrayList<Music>)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>(){

    class MusicViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val txtSong : TextView = itemView.findViewById(R.id.txtSong)
        val txtSinger : TextView = itemView.findViewById(R.id.txtSinger)
        val heartImage : ImageView = itemView.findViewById(R.id.heartImage)
        val forbiddenImage : ImageView = itemView.findViewById(R.id.forbiddenImage)
        val menuImage : ImageView = itemView.findViewById(R.id.menuImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music , parent , false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var fav = false
        val music = musicList[position]
        holder.imageView.setImageResource(music.image)
        holder.txtSong.text = music.song
        holder.txtSinger.text = music.artist
        holder.heartImage.setOnClickListener {
            if (!fav) {
                holder.heartImage.setImageResource(R.drawable.heart)
                fav = true
            } else {
                holder.heartImage.setImageResource(R.drawable.heartfull2)
                fav = false
            }
        }
        //holder.heartImage.setImageResource(music.heartImage)
        holder.forbiddenImage.setImageResource(music.forbiddenImage)
        holder.menuImage.setImageResource(music.menuImage)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}