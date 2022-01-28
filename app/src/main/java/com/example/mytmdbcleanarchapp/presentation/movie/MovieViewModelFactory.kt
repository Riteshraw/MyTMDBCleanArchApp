package com.example.mytmdbcleanarchapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytmdbcleanarchapp.domain.usecase.GetMovieUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateMovieUserCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUserCase: UpdateMovieUserCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMovieUserCase) as T
    }
}