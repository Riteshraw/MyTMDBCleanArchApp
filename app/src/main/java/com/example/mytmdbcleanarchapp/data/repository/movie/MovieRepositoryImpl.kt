package com.example.mytmdbcleanarchapp.data.repository.movie

import android.util.Log
import com.example.mytmdbcleanarchapp.domain.repository.MovieRepository
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.data.model.Movie.MovieList
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieCatchDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCatchDataSource: MovieCatchDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMovieFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCatchDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMovieFromAPI():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        return movieList
    }

    suspend fun getMovieFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        }
        else{
            movieList = getMovieFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCatchDataSource.getMoviesFromCache()
        } catch (exe: Exception) {
            Log.i("MyTag", exe.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        }
        else{
            movieList = getMovieFromDb()
            movieCatchDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }


}