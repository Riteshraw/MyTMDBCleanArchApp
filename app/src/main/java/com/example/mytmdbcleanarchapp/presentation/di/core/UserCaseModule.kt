package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.domain.repository.ArtistRepository
import com.example.mytmdbcleanarchapp.domain.repository.MovieRepository
import com.example.mytmdbcleanarchapp.domain.repository.TvShowRepository
import com.example.mytmdbcleanarchapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase =
        GetMovieUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUserCase =
        UpdateMovieUserCase(movieRepository)

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase =
        GetArtistUseCase(artistRepository)

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase =
        UpdateArtistUseCase(artistRepository)

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase =
        GetTvShowUseCase(tvShowRepository)

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase =
        UpdateTvShowUseCase(tvShowRepository)
}