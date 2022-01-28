package com.example.mytmdbcleanarchapp.data.repository.movie.dataSource

import com.example.mytmdbcleanarchapp.data.model.Movie.Movie

interface MovieCatchDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)

}