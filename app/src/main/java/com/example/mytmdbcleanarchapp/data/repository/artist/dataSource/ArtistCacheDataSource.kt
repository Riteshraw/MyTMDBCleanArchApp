package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artistList:List<Artist>)
}