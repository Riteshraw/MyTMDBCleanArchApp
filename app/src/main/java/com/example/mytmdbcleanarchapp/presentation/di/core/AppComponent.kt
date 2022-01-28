package com.example.mytmdbcleanarchapp.presentation.di.core

import com.example.mytmdbcleanarchapp.presentation.di.artist.ArtistSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.movie.MovieSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DbModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
        RepositoryModule::class,
        UserCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}