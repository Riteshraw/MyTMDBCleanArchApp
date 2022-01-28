package com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.model.artist.Artist
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.ArtistCacheDataSource
import com.example.mytmdbcleanarchapp.data.repository.tvShow.dataSource.TvShowCacheDataSource

class ArtistCacheDataSourceImpl() : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList.addAll(artist)
    }


}
