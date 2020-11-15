package a.alt.z.tmdb.model

import com.google.gson.annotations.SerializedName

data class Response<T> (
    val page: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val results: List<T>?
)