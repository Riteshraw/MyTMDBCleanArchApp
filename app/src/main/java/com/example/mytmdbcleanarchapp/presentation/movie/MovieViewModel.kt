package com.example.mytmdbcleanarchapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.domain.usecase.GetArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.GetMovieUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateMovieUserCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUserCase: UpdateMovieUserCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList: List<Movie>? = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList: List<Movie>? = updateMovieUserCase.execute()
        emit(movieList)
    }

}