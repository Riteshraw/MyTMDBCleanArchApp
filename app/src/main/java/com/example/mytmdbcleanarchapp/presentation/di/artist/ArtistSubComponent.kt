package com.example.mytmdbcleanarchapp.presentation.di.artist

import com.example.mytmdbcleanarchapp.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }

    fun inject(artistActivity: ArtistActivity)

}