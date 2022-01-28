package com.example.mytmdbcleanarchapp.data.repository.movie.dataSource

import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import retrofit2.Response

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movieList:List<Movie>)
    suspend fun clearAll()

}