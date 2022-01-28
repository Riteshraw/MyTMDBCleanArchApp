package com.example.mytmdbcleanarchapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytmdbcleanarchapp.domain.usecase.GetArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.GetTvShowUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}