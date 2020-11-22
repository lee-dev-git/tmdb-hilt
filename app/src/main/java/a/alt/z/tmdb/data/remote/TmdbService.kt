package a.alt.z.tmdb.data.remote

import a.alt.z.tmdb.data.model.TmdbMovie
import a.alt.z.tmdb.data.model.TmdbResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") language: String = "ko-KR"): TmdbResponse<TmdbMovie>

    @GET("/search/movie")
    suspend fun searchMovie(@Query("query") query: String): TmdbResponse<TmdbMovie>
}