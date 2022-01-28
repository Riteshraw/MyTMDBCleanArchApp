package com.example.mytmdbcleanarchapp.data.repository.movie.dataSourceImpl

import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.data.repository.movie.dataSource.MovieCatchDataSource

class MovieCacheDataSourceImpl: MovieCatchDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }

}