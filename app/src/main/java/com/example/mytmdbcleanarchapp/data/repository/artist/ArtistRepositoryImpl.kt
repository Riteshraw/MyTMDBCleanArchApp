package com.example.mytmdbcleanarchapp.data.repository.tvShow

import android.util.Log
import com.example.mytmdbcleanarchapp.domain.repository.ArtistRepository
import com.example.mytmdbcleanarchapp.data.model.artist.Artist
import com.example.mytmdbcleanarchapp.data.model.artist.ArtistList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.*
import java.lang.Exception

class ArtistRepositoryImpl(
    private val tvShowRemoteDataSource: ArtistRemoteDataSource,
    private val tvShowLocalDataSource: ArtistLocalDataSource,
    private val tvShowCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val tvShowList = getArtistFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveArtistToDB(tvShowList)
        tvShowCacheDataSource.saveArtistToCache(tvShowList)
        return tvShowList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = tvShowRemoteDataSource.getArtist()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.results
            }
        } catch (exe: Exception) {
            Log.i("MyTag", "Exception while fetching TvShows from API : ${exe.message}")
        }

        return artistList
    }

    suspend fun getArtistFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = tvShowLocalDataSource.getArtistFromDB()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            tvShowLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = tvShowCacheDataSource.getArtistFromCache()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (artistList.isNotEmpty())
            return artistList
        else {
            artistList = getArtistFromDb()
            tvShowCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}