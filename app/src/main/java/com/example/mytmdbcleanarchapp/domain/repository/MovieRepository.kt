package com.example.mytmdbcleanarchapp.domain.repository

import com.example.mytmdbcleanarchapp.data.model.Movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}