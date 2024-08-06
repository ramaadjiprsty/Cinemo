package com.example.favorite.di

import android.content.Context
import com.example.cinemo.di.FavoriteModuleDependencies
import com.example.favorite.ui.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent{
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun context(context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}