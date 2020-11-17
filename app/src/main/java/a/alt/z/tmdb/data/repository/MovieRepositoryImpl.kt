package a.alt.z.tmdb.data.repository

import a.alt.z.tmdb.data.source.MovieLocalDataSource
import a.alt.z.tmdb.data.source.MovieRemoteDataSource
import a.alt.z.tmdb.data.db.MovieEntity
import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {

    override suspend fun searchMovie(query: String): List<Movie> = TODO()

    override fun popularMovies(): Flow<List<Movie>> {
        return movieLocalDataSource.popularMovies()
            .map { entities -> entities.map { it.toMovie() } }
    }

    override suspend fun reloadPopularMovies() {
        val popularMovies = movieRemoteDataSource.getPopularMovies()
        if(popularMovies.isNotEmpty()) movieLocalDataSource.savePopularMovies(popularMovies)
    }
}

fun MovieEntity.toMovie(): Movie = TODO()

