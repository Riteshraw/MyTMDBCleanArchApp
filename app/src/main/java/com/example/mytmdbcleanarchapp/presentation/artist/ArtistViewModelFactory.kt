package com.example.mytmdbcleanarchapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytmdbcleanarchapp.domain.usecase.GetArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.GetMovieUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateMovieUserCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}