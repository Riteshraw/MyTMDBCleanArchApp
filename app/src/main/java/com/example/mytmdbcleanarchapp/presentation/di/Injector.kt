package com.example.mytmdbcleanarchapp.presentation.di

import com.example.mytmdbcleanarchapp.presentation.di.artist.ArtistSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.movie.MovieSubComponent
import com.example.mytmdbcleanarchapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubcomponent():MovieSubComponent
    fun createTvShowSubcomponent():TvShowSubComponent
    fun createArtistSubcomponent(): ArtistSubComponent

}