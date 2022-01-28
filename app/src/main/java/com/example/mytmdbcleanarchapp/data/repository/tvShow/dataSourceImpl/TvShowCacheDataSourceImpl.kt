package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl() : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }


}
