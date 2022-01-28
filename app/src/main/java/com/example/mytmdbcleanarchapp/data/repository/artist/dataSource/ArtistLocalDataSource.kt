package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.artist.Artist
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import retrofit2.Response

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(tvShowList:List<Artist>)
    suspend fun clearAll()

}