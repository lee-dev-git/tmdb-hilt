package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.R
import a.alt.z.tmdb.databinding.FragmentPopularMoviesBinding
import a.alt.z.tmdb.util.viewBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PopularMoviesFragment: Fragment(R.layout.fragment_popular_movies) {

    private val binding by viewBinding(FragmentPopularMoviesBinding::bind)

    private val adapter = PopularMoviesAdapter()

    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        setupObserver()
    }

    private fun init() {
        binding.apply {
            popularMoviesRecyclerView.adapter = adapter
            popularMoviesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupObserver() {
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            it.getValueOrNull()
                ?.let { popularMovies ->
                    Timber.d("<observe.popularMovies>")
                    adapter.submitList(popularMovies)
                    Timber.d("</observe.popularMovies>")
                }
        }
    }
}