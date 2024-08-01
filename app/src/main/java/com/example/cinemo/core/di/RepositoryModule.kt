package com.example.cinemo.core.di

import android.content.Context
import androidx.room.Room
import com.example.cinemo.core.data.source.local.room.MoviesDao
import com.example.cinemo.core.data.source.local.room.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


}