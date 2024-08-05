package com.example.cinemo.detail

import androidx.lifecycle.ViewModel
import com.example.cinemo.core.domain.model.Movie
import com.example.cinemo.core.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase): ViewModel() {
    fun setFavoriteMovies(movie: Movie, newState: Boolean) {
        return moviesUseCase.setFavoriteMovies(movie, newState)
    }
}