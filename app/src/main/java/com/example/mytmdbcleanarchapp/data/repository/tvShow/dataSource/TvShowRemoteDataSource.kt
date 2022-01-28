package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}