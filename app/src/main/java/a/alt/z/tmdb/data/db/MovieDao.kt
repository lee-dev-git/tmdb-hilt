package a.alt.z.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun popularMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movie")
    suspend fun clear()
}