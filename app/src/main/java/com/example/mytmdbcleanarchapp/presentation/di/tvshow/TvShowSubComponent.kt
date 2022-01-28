package com.example.mytmdbcleanarchapp.presentation.di.tvshow

import com.example.mytmdbcleanarchapp.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

    fun inject(artistActivity: TvShowActivity)

}