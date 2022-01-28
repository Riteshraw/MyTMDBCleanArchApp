package com.example.mytmdbcleanarchapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mytmdbcleanarchapp.R
import com.example.mytmdbcleanarchapp.databinding.ActivityHomeBinding
import com.example.mytmdbcleanarchapp.presentation.artist.ArtistActivity
import com.example.mytmdbcleanarchapp.presentation.movie.MovieActivity
import com.example.mytmdbcleanarchapp.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnMovie.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.btnTvShow.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
        binding.btnArtist.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }

    }
}