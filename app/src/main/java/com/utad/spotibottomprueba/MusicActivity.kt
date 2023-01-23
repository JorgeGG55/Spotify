package com.utad.spotibottomprueba

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        recyclerView = findViewById(R.id.musicRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        musicList = ArrayList()

        musicList.add(Music(R.drawable.wanda, "WANDA", "Quevedo", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))
        musicList.add(Music(R.drawable.dominicana, "Dominicana", "Rvfv, Morad", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))
        musicList.add(Music(R.drawable.marisola, "Marisola", "Cris Mj", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))
        musicList.add(Music(R.drawable.jumpa, "La Jumpa", "Arcángel", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))
        musicList.add(Music(R.drawable.easymoney, "Girl", "Myke Towers", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))
        musicList.add(Music(R.drawable.star, "5 Star", "Eladio Carrion", R.drawable.heart , R.drawable.forbidden , R.drawable.menu))

        musicAdapter = MusicAdapter(musicList)
        recyclerView.adapter = musicAdapter
    }
}