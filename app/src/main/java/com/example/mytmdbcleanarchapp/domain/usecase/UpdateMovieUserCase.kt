package com.example.mytmdbcleanarchapp.domain.usecase

import com.example.mytmdbcleanarchapp.domain.repository.MovieRepository
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie

class UpdateMovieUserCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}