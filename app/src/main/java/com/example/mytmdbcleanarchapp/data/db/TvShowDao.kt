package com.example.mytmdbcleanarchapp.data.db

import androidx.room.*
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow:List<TvShow>)

    @Query("Delete from popular_tvShow")
    suspend fun deleteAllTvShow()

    @Query("Select * from popular_tvShow")
    suspend fun getTvShow():List<TvShow>

}