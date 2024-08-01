package com.example.cinemo.core.domain.usecase

import com.example.cinemo.core.data.source.MoviesRepository
import com.example.cinemo.core.data.source.Resource
import com.example.cinemo.core.domain.model.Movie
import com.example.cinemo.core.domain.repository.IMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private val moviesRepository: IMoviesRepository): MoviesUseCase {

    override fun getMovies(): Flow<Resource<List<Movie>>> {
        return moviesRepository.getMovies()
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return moviesRepository.getFavoriteMovie()
    }

    override fun setFavoriteMovies(movie: Movie, state: Boolean) {
        return moviesRepository.setFavoriteMovie(movie, state)
    }


}