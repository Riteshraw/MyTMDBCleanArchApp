package com.example.mytmdbcleanarchapp.presentation.di.artist

import com.example.mytmdbcleanarchapp.domain.usecase.GetArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.GetTvShowUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateArtistUseCase
import com.example.mytmdbcleanarchapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun artistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
    }

}