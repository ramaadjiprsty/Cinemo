package com.example.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cinemo.core.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteViewModel(moviesUseCase: MoviesUseCase) : ViewModel() {
    val favoriteMovies = moviesUseCase.getFavoriteMovies().asLiveData()
}