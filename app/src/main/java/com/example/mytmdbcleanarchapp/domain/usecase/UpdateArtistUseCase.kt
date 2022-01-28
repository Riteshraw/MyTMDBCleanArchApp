package com.example.mytmdbcleanarchapp.domain.usecase

import com.example.mytmdbcleanarchapp.domain.repository.ArtistRepository
import com.example.mytmdbcleanarchapp.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.getArtist()

}