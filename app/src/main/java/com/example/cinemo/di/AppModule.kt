package com.example.cinemo.di

import com.example.cinemo.core.domain.usecase.MoviesInteractor
import com.example.cinemo.core.domain.usecase.MoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMoviesUseCase(moviesInteractor: MoviesInteractor): MoviesUseCase
}