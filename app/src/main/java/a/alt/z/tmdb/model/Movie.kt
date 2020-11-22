package a.alt.z.tmdb.model

data class Movie(
    val id: Long,
    val posterUrl: String?,
    val title: String,
    val overview: String,
    val popularity: Double
)