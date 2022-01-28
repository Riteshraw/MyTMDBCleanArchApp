package com.example.mytmdbcleanarchapp.domain.repository

import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?

}