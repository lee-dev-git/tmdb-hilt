package a.alt.z.tmdb.api

import a.alt.z.tmdb.model.Movie
import a.alt.z.tmdb.model.Response
import retrofit2.http.GET

interface TmdbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(language: String = "ko-KR"): Response<Movie>

    @GET("/search/movie")
    suspend fun searchMovie(query: String): Response<Movie>
}