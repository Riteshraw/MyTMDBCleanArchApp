package com.example.mytmdbcleanarchapp.presentation

import android.app.Application
import android.os.Build
import com.example.mytmdbcleanarchapp.BuildConfig
import com.example.mytmdbcleanarchapp.presentation.di.Injector
import com.example.mytmdbcleanarchapp.presentation.di.artist.ArtistSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.core.*
import com.example.mytmdbcleanarchapp.presentation.di.movie.MovieSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Inject

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))


            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubcomponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubcomponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}