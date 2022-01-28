package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource

import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShowList:List<TvShow>)
}