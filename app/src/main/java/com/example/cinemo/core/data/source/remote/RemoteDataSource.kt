package com.example.cinemo.core.data.source.remote

import android.util.Log
import com.example.cinemo.core.data.source.remote.network.ApiResponse
import com.example.cinemo.core.data.source.remote.network.ApiService
import com.example.cinemo.core.data.source.remote.response.MovieResponse
import com.example.cinemo.core.data.source.remote.response.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getListMovies("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2ODgzNjNiOTA0ZmJkNzIyMjg0OTUyOGU4OTllMzM0NiIsIm5iZiI6MTcyMTc4NTAyNS41OTUxMDgsInN1YiI6IjY2YTA1OTk2ZmVmNjA3Njc0NjBhN2MzOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RIq10J4dpPfCbRxmWGvqvfyQUtAKkuOMxodcyrCDTEg")
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}