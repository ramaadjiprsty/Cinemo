package com.example.cinemo.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cinemo.R
import com.example.cinemo.core.domain.model.Movie
import com.example.cinemo.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovies = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovies(detailMovies)
    }

    private fun showDetailMovies(detailMovies: Movie?) {
        detailMovies?.let {
            binding.tvTitle.text = detailMovies.title
            binding.tvDescription.text = detailMovies.overview
            binding.tvRating.text = detailMovies.voteAverage.toString()
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${detailMovies.posterPath}")
                .into(binding.ivMovie)

            var favoriteState = detailMovies.isFavorite
            setFavoriteState(favoriteState!!)
            binding.fabFavorite.setOnClickListener {
                favoriteState = !favoriteState!!
                if (favoriteState == true) {
                    favoriteMessage("Added to favorite")
                } else {
                    favoriteMessage("Removed from favorite")
                }
                viewModel.setFavoriteMovies(detailMovies, favoriteState!!)
                setFavoriteState(favoriteState!!)
            }
        }
    }

    private fun setFavoriteState(favoriteState: Boolean) {
        if (favoriteState) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24))
        }
    }

    private fun favoriteMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}