package com.example.mytmdbcleanarchapp.presentation.di.movie

import com.example.mytmdbcleanarchapp.domain.usecase.*
import com.example.mytmdbcleanarchapp.presentation.artist.ArtistViewModelFactory
import com.example.mytmdbcleanarchapp.presentation.di.tvshow.TvShowScope
import com.example.mytmdbcleanarchapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun movieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUserCase: UpdateMovieUserCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUserCase)
    }

}