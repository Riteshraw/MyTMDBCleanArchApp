package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import retrofit2.Response

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShowList:List<TvShow>)
    suspend fun clearAll()

}