package com.example.mytmdbcleanarchapp.presentation.di.movie

import com.example.mytmdbcleanarchapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

    fun inject(artistActivity: MovieActivity)

}