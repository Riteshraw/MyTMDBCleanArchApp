package com.example.mytmdbcleanarchapp.data.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveMovies(movie:List<Movie>)

    @Query("Delete from popular_movie")
    suspend fun deleteAllMovies()

    @Query("Select * from popular_movie")
    suspend fun getMovies():List<Movie>

}