package pr.dwkim.themoviedatabase.repository.remote.result

import com.google.gson.annotations.SerializedName
import pr.dwkim.themoviedatabase.repository.remote.model.Movie

data class PopularListResult(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("results") val results: List<Movie?>? = null
)