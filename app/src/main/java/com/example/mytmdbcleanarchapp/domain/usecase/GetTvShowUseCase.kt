package com.example.mytmdbcleanarchapp.domain.usecase

import com.example.mytmdbcleanarchapp.domain.repository.TvShowRepository
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow

class GetTvShowUseCase(private val tvRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvRepository.getTvShows()

}