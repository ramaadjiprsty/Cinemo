package com.example.cinemo.core.data.source

import com.example.cinemo.core.data.source.local.LocalDataSource
import com.example.cinemo.core.data.source.remote.RemoteDataSource
import com.example.cinemo.core.data.source.remote.network.ApiResponse
import com.example.cinemo.core.data.source.remote.response.ResultsItem
import com.example.cinemo.core.domain.model.Movie
import com.example.cinemo.core.domain.repository.IMoviesRepository
import com.example.cinemo.core.utils.AppExecutors
import com.example.cinemo.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMoviesRepository {

    override fun getMovies(): Flow<Resource<List<Movie>>>  =
        object : NetworkBoundResource<List<Movie>, List<ResultsItem>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getMovies()


            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val moviesList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertMovies(moviesList)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()


    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val moviesEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute{ localDataSource.setFavoriteMovies(moviesEntity, state) }
    }
}