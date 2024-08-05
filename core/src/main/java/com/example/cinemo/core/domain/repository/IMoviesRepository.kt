package com.example.cinemo.core.domain.repository

import com.example.cinemo.core.data.source.Resource
import com.example.cinemo.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {

    fun getMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}