package com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.model.Movie.MovieList
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}
