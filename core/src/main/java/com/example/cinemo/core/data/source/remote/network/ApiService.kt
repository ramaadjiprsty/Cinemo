package com.example.cinemo.core.data.source.remote.network

import com.example.cinemo.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getListMovies(
    ): MovieResponse

}