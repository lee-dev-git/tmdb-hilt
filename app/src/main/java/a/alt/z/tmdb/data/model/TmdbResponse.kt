package a.alt.z.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TmdbResponse<T> (
    val page: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val results: List<T>?
)