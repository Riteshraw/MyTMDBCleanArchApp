package com.example.mytmdbcleanarchapp.data.repository.tvShow

import android.util.Log
import com.example.mytmdbcleanarchapp.domain.repository.TvShowRepository
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvShowList = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        return tvShowList
    }

    suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvShowList = body.results
            }
        } catch (exe: Exception) {
            Log.i("MyTag", "Exception while fetching TvShows from API : ${exe.message}")
        }

        return tvShowList
    }

    suspend fun getTvShowFromDb(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (tvShowList.size > 0)
            return tvShowList
        else {
            tvShowList = getTvShowFromDb()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}