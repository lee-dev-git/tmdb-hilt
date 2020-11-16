package a.alt.z.tmdb.data.remote

import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.data.model.TmdbResponse
import retrofit2.http.GET

interface TmdbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(language: String = "ko-KR"): TmdbResponse<TmdbMovie>

    @GET("/search/movie")
    suspend fun searchMovie(query: String): TmdbResponse<TmdbMovie>
}