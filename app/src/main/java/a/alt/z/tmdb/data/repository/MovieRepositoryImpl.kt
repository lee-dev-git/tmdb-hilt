package a.alt.z.tmdb.data.repository

import a.alt.z.tmdb.data.source.MovieLocalDataSource
import a.alt.z.tmdb.data.source.MovieRemoteDataSource
import a.alt.z.tmdb.data.db.MovieEntity
import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.model.Movie
import a.alt.z.tmdb.util.debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {

    /* in-memory cache */
    private var popularMovies: List<TmdbMovie>? = null

    override suspend fun searchMovie(query: String): List<Movie> = TODO()

    override fun popularMovies(): Flow<List<Movie>> {
        debug { "<MovieRepositoryImpl.popularMovies>" }
        if(popularMovies == null) {
            /* TODO */
            try { GlobalScope.launch(Dispatchers.IO) { reloadPopularMovies() } }
            catch (exception: IOException) { debug(exception) { "<MovieRepositoryImpl.popularMovies>" } }
        }

        return movieLocalDataSource
                .popularMovies()
                .map { entities -> entities.map { it.toMovie() } }
                .also { debug { "</MovieRepositoryImpl.popularMovies>" } }
    }

    override suspend fun reloadPopularMovies() {
        Timber.d("<MovieRepositoryImpl.reloadPopularMovies>")
        popularMovies = movieRemoteDataSource.getPopularMovies()
        popularMovies
                ?.takeIf { it.isNotEmpty() }
                ?.let { movieLocalDataSource.savePopularMovies(it) }
        Timber.d("</MovieRepositoryImpl.reloadPopularMovies>")
    }
}

fun MovieEntity.toMovie(): Movie
        = Movie(id = id, posterUrl = posterUrl, title = title, overview = overview, popularity = popularity)

