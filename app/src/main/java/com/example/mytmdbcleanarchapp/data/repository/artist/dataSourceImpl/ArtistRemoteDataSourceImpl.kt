package com.example.mytmdbcleanarchapp.data.repository.artist.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.model.artist.ArtistList
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistRemoteDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}
