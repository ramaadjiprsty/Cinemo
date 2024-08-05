package com.example.cinemo.core.data.source.local

import com.example.cinemo.core.data.source.local.entity.MoviesEntity
import com.example.cinemo.core.data.source.local.room.MoviesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val moviesDao: MoviesDao) {

    fun getMovies(): Flow<List<MoviesEntity>> = moviesDao.getMovies()

    fun getFavoriteMovies(): Flow<List<MoviesEntity>> = moviesDao.getFavoriteMovies()

    suspend fun insertMovies(moviesList: List<MoviesEntity>) = moviesDao.insertMovies(moviesList)

    fun setFavoriteMovies(movies: MoviesEntity, newState: Boolean) {
        movies.isFavorite = newState
        moviesDao.updateFavoriteMovies(movies)
    }
}