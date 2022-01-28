package com.example.mytmdbcleanarchapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mytmdbcleanarchapp.R
import com.example.mytmdbcleanarchapp.databinding.ActivityArtistBinding
import com.example.mytmdbcleanarchapp.databinding.ActivityTvShowBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)

    }
}