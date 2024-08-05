package com.example.cinemo.core.utils

import com.example.cinemo.core.data.source.local.entity.MoviesEntity
import com.example.cinemo.core.data.source.remote.response.MovieResponse
import com.example.cinemo.core.data.source.remote.response.ResultsItem
import com.example.cinemo.core.domain.model.Movie

object DataMapper {
    fun mapResponseToEntities(input: List<ResultsItem>): List<MoviesEntity> {
        val moviesList = ArrayList<MoviesEntity>()
        input.map {
            val movies = MoviesEntity(
                id = it.id!!,
                movieTitle = it.title!!,
                movieDescription = it.overview!!,
                movieReleaseDate = it.releaseDate!!,
                voteAverage = it.voteAverage!!,
                moviePoster = it.posterPath!!,
                isFavorite = false
            )
            moviesList.add(movies)
        }
        return moviesList
    }

    fun mapEntitiesToDomain(input: List<MoviesEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.movieTitle,
                overview = it.movieDescription,
                releaseDate = it.movieReleaseDate,
                voteAverage = it.voteAverage,
                isFavorite = it.isFavorite,
                posterPath = it.moviePoster
            )
        }

    fun mapDomainToEntity(input: Movie) = MoviesEntity(
        id = input.id!!,
        movieTitle = input.title!!,
        movieDescription = input.overview!!,
        movieReleaseDate = input.releaseDate!!,
        voteAverage = input.voteAverage!!,
        moviePoster = input.posterPath!!,
        isFavorite = input.isFavorite!!
    )
}