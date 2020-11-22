package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.domain.usecase.popular.GetPopularMoviesUseCase
import a.alt.z.tmdb.util.debug
import a.alt.z.tmdb.util.toLoadState
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import timber.log.Timber

class PopularMoviesViewModel @ViewModelInject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    init {
        debug { "PopularMoviesViewModel.init" }
    }

    val popularMovies = getPopularMoviesUseCase(Unit)
        .toLoadState()
        .asLiveData()

    fun refresh() {

    }
}