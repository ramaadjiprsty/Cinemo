package com.example.cinemo.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cinemo.core.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(moviesUseCase: MoviesUseCase) : ViewModel() {
    val favoriteMovies = moviesUseCase.getFavoriteMovies().asLiveData()
}