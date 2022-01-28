package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.data.db.ArtistDao
import com.example.mytmdbcleanarchapp.data.db.MovieDao
import com.example.mytmdbcleanarchapp.data.db.TvShowDao
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieCatchDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl.ArtistLocalDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDao)

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)

}