package com.example.mytmdbcleanarchapp.data.repository.movie.dataSource

import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.data.model.Movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies():Response<MovieList>

}