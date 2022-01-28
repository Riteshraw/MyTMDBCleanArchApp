package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.data.repository.movie.MovieRepositoryImpl
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieCatchDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.ArtistRepositoryImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.TvShowRepositoryImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.*
import com.example.mytmdbcleanarchapp.domain.repository.ArtistRepository
import com.example.mytmdbcleanarchapp.domain.repository.MovieRepository
import com.example.mytmdbcleanarchapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCatchDataSource: MovieCatchDataSource
    ): MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCatchDataSource)

    @Singleton
    @Provides
    fun provideTvShowRepository(
        movieRemoteDataSource: TvShowRemoteDataSource,
        movieLocalDataSource: TvShowLocalDataSource,
        movieCatchDataSource: TvShowCacheDataSource
    ): TvShowRepository =
        TvShowRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCatchDataSource)

    @Singleton
    @Provides
    fun provideArtistRepository(
        movieRemoteDataSource: ArtistRemoteDataSource,
        movieLocalDataSource: ArtistLocalDataSource,
        movieCatchDataSource: ArtistCacheDataSource
    ): ArtistRepository =
        ArtistRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCatchDataSource)


}