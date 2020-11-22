package a.alt.z.tmdb.data.source

import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.data.remote.TmdbService
import a.alt.z.tmdb.model.Movie
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

interface MovieRemoteDataSource {
    suspend fun searchMovie(query: String): List<TmdbMovie>
    suspend fun getPopularMovies(): List<TmdbMovie>
}

@Singleton
class TmdbMovieDataSource @Inject constructor(
    private val tmdbService: TmdbService
): MovieRemoteDataSource {

    override suspend fun searchMovie(query: String): List<TmdbMovie> = tmdbService.searchMovie(query)
        .results
        ?: emptyList()


    override suspend fun getPopularMovies(): List<TmdbMovie> {

        Timber.d("TmdbMovieDataSource.getPopularMovies")
        return tmdbService.getPopularMovies()
                .results
                ?: emptyList()
    }
}