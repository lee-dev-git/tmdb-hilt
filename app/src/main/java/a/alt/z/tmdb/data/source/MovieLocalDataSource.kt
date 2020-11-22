package a.alt.z.tmdb.data.source

import a.alt.z.tmdb.data.db.MovieDao
import a.alt.z.tmdb.data.db.MovieEntity
import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.data.model.posterUrl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface MovieLocalDataSource {

    fun popularMovies(): Flow<List<MovieEntity>>

    suspend fun savePopularMovies(movies: List<TmdbMovie>)
}

@Singleton
class DBMovieDataSource @Inject constructor(
    private val movieDao: MovieDao
): MovieLocalDataSource {

    override fun popularMovies(): Flow<List<MovieEntity>> = movieDao.popularMovies()

    override suspend fun savePopularMovies(movies: List<TmdbMovie>) {
        movies.takeIf { it.isNotEmpty() }
            ?.map { it.toMovieEntity() }
            ?.let {
                movieDao.clear()
                movieDao.savePopularMovies(it)
            }
    }
}

fun TmdbMovie.toMovieEntity(): MovieEntity
        = MovieEntity(id = id, posterUrl = posterUrl ?: backdropPath, title = title, overview = overview, popularity = popularity)