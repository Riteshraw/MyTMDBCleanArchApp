package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.api.TMDBService
import com.example.mytmdbcleanarchapp.data.db.ArtistDao
import com.example.mytmdbcleanarchapp.data.db.TvShowDao
import com.example.mytmdbcleanarchapp.data.model.artist.Artist
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShowList
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> = artistDao.getArtist()

    override suspend fun saveArtistToDB(tvShowList: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtist(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtist()
        }
    }

}
