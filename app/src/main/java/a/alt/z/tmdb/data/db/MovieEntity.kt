package a.alt.z.tmdb.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "poster_url")
    val posterUrl: String?,
    val title: String,
    val overview: String,
    val popularity: Double
)