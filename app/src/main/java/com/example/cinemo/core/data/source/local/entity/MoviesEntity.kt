package com.example.cinemo.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MoviesEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "movieTitle")
    val movieTitle: String,

    @ColumnInfo(name = "movieDescription")
    val movieDescription: String,

    @ColumnInfo(name = "movieReleaseDate")
    val movieReleaseDate: String,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

)