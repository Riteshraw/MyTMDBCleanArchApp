package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.artist.ArtistList
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtist(): Response<ArtistList>

}