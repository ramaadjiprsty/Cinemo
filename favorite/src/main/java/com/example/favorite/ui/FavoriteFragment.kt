package com.example.favorite.ui

import android.content.Context
import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinemo.core.ui.MoviesAdapter
import com.example.cinemo.databinding.FragmentFavoriteBinding
import com.example.cinemo.detail.DetailActivity
import com.example.favorite.di.DaggerFavoriteComponent
import com.example.cinemo.di.FavoriteModuleDependencies
import com.example.favorite.di.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val moviesAdapter = MoviesAdapter()
            moviesAdapter.onItemClick = {
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, it)
                startActivity(intent)
            }

            viewModel.favoriteMovies.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    binding.noFavorite.visibility = View.GONE
                } else {
                    binding.noFavorite.visibility = View.VISIBLE
                }
                moviesAdapter.setData(it)
            }

            binding.rvMovies.apply {
                layoutManager = GridLayoutManager(requireActivity(), 2)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}