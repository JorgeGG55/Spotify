package com.utad.spotibottomprueba

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utad.spotibottomprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var playlist : ArrayList<Playlist>
    private lateinit var playlistAdapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        recyclerView = findViewById(R.id.mainRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        playlist = ArrayList()

        playlist.add(Playlist(R.drawable.pegao, "Pegao", "2.234.422 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.exitos, "Éxitos España", "2.135.132 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.mora, "This is Mora", "3.758.825 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.vivalatino, "Viva Latino", "13.151.779 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.popinternacional, "Pop Internacional", "3.234.422 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.paraiso, "PARAÍSO", "5.875.259 SEGUIDORES"))
        playlist.add(Playlist(R.drawable.black, "", ""))

        playlistAdapter = PlaylistAdapter(playlist)
        recyclerView.adapter = playlistAdapter

        playlistAdapter.onItemClick = {
            val intent = Intent(this, MusicActivity::class.java)
            intent.putExtra("playlist", it)
            startActivity(intent)
        }
    }
}