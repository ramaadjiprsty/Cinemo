package com.example.cinemo.core.domain.usecase

import com.example.cinemo.core.data.source.Resource
import com.example.cinemo.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesUseCase {
    fun getMovies(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun setFavoriteMovies(movie: Movie, state: Boolean)
}