package com.example.mytmdbcleanarchapp.data.db

import androidx.room.*
import com.example.mytmdbcleanarchapp.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist:List<Artist>)

    @Query("Delete from popular_artist")
    suspend fun deleteAllArtist()

    @Query("Select * from popular_artist")
    suspend fun getArtist():List<Artist>

}