package a.alt.z.tmdb.domain.usecase.popular

import a.alt.z.tmdb.di.IODispatcher
import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

class ReloadPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): UseCase<Unit, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit) = movieRepository.reloadPopularMovies()
}