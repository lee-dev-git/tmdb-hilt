package a.alt.z.tmdb.domain.repository

import a.alt.z.tmdb.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>

    fun popularMovies(): Flow<List<Movie>>

    suspend fun reloadPopularMovies()
}