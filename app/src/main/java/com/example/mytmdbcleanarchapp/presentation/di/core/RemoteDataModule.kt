package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistRemoteDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val api_key: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService, api_key)

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(tmdbService, api_key)

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(tmdbService, api_key)

}