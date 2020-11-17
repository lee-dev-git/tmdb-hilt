package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.domain.usecase.popular.GetPopularMoviesUseCase
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import timber.log.Timber

class PopularMoviesViewModel @ViewModelInject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    val popularMovies = liveData {
        getPopularMoviesUseCase(Unit)
            .catch { e ->
                Timber.d(e)
                emit(emptyList())
            }
            .collect { emit(it) }
    }
}