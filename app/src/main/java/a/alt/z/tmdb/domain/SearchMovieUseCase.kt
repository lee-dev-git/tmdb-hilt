package a.alt.z.tmdb.domain

import a.alt.z.tmdb.di.IODispatcher
import a.alt.z.tmdb.model.Movie
import kotlinx.coroutines.CoroutineDispatcher

class SearchMovieUseCase(
    @IODispatcher dispatcher: CoroutineDispatcher
): UseCase<String, List<Movie>>(dispatcher) {

    override fun execute(parameters: String): List<Movie> {
        TODO("Not yet implemented")
    }
}