package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieCatchDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistCacheDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl.ArtistCacheDataSourceImpl
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCatchDataSource =
        MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource =
        TvShowCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource =
        ArtistCacheDataSourceImpl()
}