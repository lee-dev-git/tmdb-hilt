package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment: Fragment(R.layout.fragment_popular_movies) {

    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        setupObserver()
    }

    private fun init() {

    }

    private fun setupObserver() {

    }
}