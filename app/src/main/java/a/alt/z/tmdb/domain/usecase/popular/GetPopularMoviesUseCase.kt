package a.alt.z.tmdb.domain.usecase.popular

import a.alt.z.tmdb.di.IODispatcher
import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.domain.usecase.FlowUseCase
import a.alt.z.tmdb.domain.usecase.Result
import a.alt.z.tmdb.domain.usecase.UseCase
import a.alt.z.tmdb.model.Movie
import a.alt.z.tmdb.util.debug
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<Movie>>(coroutineDispatcher) {

    override fun execute(parameters: Unit): Flow<List<Movie>> {
        debug { "<GetPopularMoviesUseCase.execute>" }
        return movieRepository.popularMovies()
                .also { debug { "</GetPopularMoviesUseCase.execute>" } }
    }
}