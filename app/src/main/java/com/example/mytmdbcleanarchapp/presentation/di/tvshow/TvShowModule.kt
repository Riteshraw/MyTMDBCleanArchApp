package com.example.mytmdbcleanarchapp.presentation.di.tvshow

import com.example.mytmdbcleanarchapp.domain.usecase.*
import com.example.mytmdbcleanarchapp.presentation.di.movie.MovieScope
import com.example.mytmdbcleanarchapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun tvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }

}