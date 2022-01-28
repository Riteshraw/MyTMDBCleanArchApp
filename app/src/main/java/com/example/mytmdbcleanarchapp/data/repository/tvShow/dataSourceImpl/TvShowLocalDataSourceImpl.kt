package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.db.TvShowDao
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class TvShowLocalDataSourceImpl(
    private val tvShowDao: TvShowDao
) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getTvShow()

    override suspend fun saveTvShowsToDB(tvShowList: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShow(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }

}
