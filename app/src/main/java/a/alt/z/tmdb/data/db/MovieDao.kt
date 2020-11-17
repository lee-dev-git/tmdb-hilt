package a.alt.z.tmdb.data.db

import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    fun popularMovies(): Flow<List<MovieEntity>>
    suspend fun savePopularMovies(movies: List<MovieEntity>)
}