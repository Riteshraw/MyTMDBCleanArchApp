package com.example.mytmdbcleanarchapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.mytmdbcleanarchapp.data.db.ArtistDao
import com.example.mytmdbcleanarchapp.data.db.MovieDao
import com.example.mytmdbcleanarchapp.data.db.TMDBDatabase
import com.example.mytmdbcleanarchapp.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideDb(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb_client")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: TMDBDatabase): MovieDao {
        return db.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(db: TMDBDatabase): TvShowDao {
        return db.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(db: TMDBDatabase): ArtistDao {
        return db.artistDao()
    }


}