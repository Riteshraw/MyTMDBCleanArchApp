package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getTvShows(apiKey)
}
