package com.example.cinemo.core.di

import com.example.cinemo.core.data.source.MoviesRepository
import com.example.cinemo.core.domain.repository.IMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(moviesRepository: MoviesRepository): IMoviesRepository
}