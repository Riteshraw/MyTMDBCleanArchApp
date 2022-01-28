package com.example.mytmdbcleanarchapp.domain.repository

import com.example.mytmdbcleanarchapp.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?

}