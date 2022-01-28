package com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.db.MovieDao
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val dao: MovieDao
) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = dao.getMovies()

    override suspend fun saveMoviesToDB(movieList: List<Movie>) {
        CoroutineScope(IO).launch {
            dao.saveMovies(movieList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            dao.deleteAllMovies()
        }
    }

}
