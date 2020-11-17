package a.alt.z.tmdb.domain.usecase.search

import a.alt.z.tmdb.di.IODispatcher
import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.domain.usecase.UseCase
import a.alt.z.tmdb.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): UseCase<String, List<Movie>>(coroutineDispatcher) {

    override suspend fun execute(parameters: String): List<Movie> = movieRepository.searchMovie(query = parameters)
}
