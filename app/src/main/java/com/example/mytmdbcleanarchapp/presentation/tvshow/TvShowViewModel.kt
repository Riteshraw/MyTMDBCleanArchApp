package com.example.mytmdbcleanarchapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mytmdbcleanarchapp.data.model.Movie.Movie
import com.example.mytmdbcleanarchapp.data.model.artist.Artist
import com.example.mytmdbcleanarchapp.data.model.tvshow.TvShow
import com.example.mytmdbcleanarchapp.domain.usecase.GetArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.GetTvShowUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateArtistUseCase
import com.example.mytmdbcleanarchapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList: List<TvShow>? = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList: List<TvShow>? = updateTvShowUseCase.execute()
        emit(tvShowList)
    }

}